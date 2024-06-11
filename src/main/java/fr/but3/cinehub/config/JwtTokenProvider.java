package fr.but3.cinehub.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import fr.but3.cinehub.service.UserDetailService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * This class provides JWT token-related functionalities.
 * <p>
 * It is responsible for generating, validating, and managing JWT tokens.
 * </p>
 */
@Component
public class JwtTokenProvider {

    @Autowired
    private UserDetailService userDetailsService;

    private String secretKey = "clement";

    /**
     * Creates a JWT token for the given username and authorities.
     * <p>
     * This method generates a JWT token with the provided username as the subject and the authorities as claims.
     * The token has a validity of 1 hour from the current time.
     * </p>
     *
     * @param username the username for which the token is to be created
     * @param authorities the authorities of the user
     * @return the generated JWT token
     */
    public String createToken(String username, Collection<? extends GrantedAuthority> authorities) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("auth", authorities.stream()
                                      .map(GrantedAuthority::getAuthority)
                                      .collect(Collectors.toList()));
        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000); // 1 hour validity

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(validity)
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact();
    }

     /**
     * Validates the given JWT token.
     * <p>
     * This method checks if the provided token is valid by parsing it with the secret key.
     * </p>
     *
     * @param token the JWT token to validate
     * @return true if the token is valid, false otherwise
     * @throws IllegalStateException if the token is expired or invalid
     */
    public boolean validateToken(String token) {
        System.out.println(token);
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new IllegalStateException("Expired or invalid JWT token");
        }
    }

    /**
     * Retrieves the authentication from the given JWT token.
     * <p>
     * This method loads the user details from the username extracted from the token and returns an authentication object.
     * </p>
     *
     * @param token the JWT token to get the authentication from
     * @return the Authentication object for the user
     */
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    /**
     * Retrieves the username from the given JWT token.
     * <p>
     * This method extracts and returns the username from the provided token.
     * </p>
     *
     * @param token the JWT token to get the username from
     * @return the username extracted from the token
     */
    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }
}
