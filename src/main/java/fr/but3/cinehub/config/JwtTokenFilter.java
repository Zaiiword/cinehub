package fr.but3.cinehub.config;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import fr.but3.cinehub.entity.User;
import fr.but3.cinehub.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Filter for JWT token authentication.
 * <p>
 * This filter validates the JWT token from the request header and sets the user identity on the Spring Security context.
 * </p>
 */
@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenUtil;
    private final UserRepository userRepo;

    /**
     * Constructs a JwtTokenFilter with the given JwtTokenProvider and UserRepository.
     *
     * @param jwtTokenUtil the JwtTokenProvider to use for token validation
     * @param userRepo the UserRepository to use for user retrieval
     */
    public JwtTokenFilter(JwtTokenProvider jwtTokenUtil,
    UserRepository userRepo) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRepo = userRepo;
    }

    /**
     * Filters the request for JWT token authentication.
     * <p>
     * This method validates the JWT token from the request header and sets the user identity on the Spring Security context.
     * </p>
     *
     * @param request the HttpServletRequest to filter
     * @param response the HttpServletResponse associated with the request
     * @param chain the FilterChain for the request
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {

                String path = request.getRequestURI();
                System.out.println(path+"AHAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                if (path != null && (path.equals("/user/register") || path.equals("/login"))) {
                    chain.doFilter(request, response);
                    return;
                }
            
        // Get authorization header and validate
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header == null || header.isEmpty() || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
    }

        // Get jwt token and validate
        final String token = header.split(" ")[1].trim();
        if (!jwtTokenUtil.validateToken(token)) {
            chain.doFilter(request, response);
            return;
        }

        // Get user identity and set it on the spring security context
        UserDetails userDetails = userRepo
            .findByMail(jwtTokenUtil.getUsername(token))
            .map(User::toUserDetails)
            .orElse(null);

        UsernamePasswordAuthenticationToken
            authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null,
                userDetails == null ?
                    List.of() : userDetails.getAuthorities()
            );

        authentication.setDetails(
            new WebAuthenticationDetailsSource().buildDetails(request)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    

}