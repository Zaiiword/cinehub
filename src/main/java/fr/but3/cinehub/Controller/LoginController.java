package fr.but3.cinehub.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.but3.cinehub.config.JwtTokenProvider;
import fr.but3.cinehub.entity.JwtResponse;
import fr.but3.cinehub.entity.LoginDto;

/**
 * This class provides the controller for login operations.
 * <p>
 * It handles HTTP POST requests for user authentication and JWT token generation.
 * </p>
 */
@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    /**
     * Constructs a new LoginController with the given AuthenticationManager and JwtTokenProvider.
     *
     * @param authenticationManager the AuthenticationManager to use for authenticating users
     * @param jwtTokenProvider the JwtTokenProvider to use for generating JWT tokens
     */
    public LoginController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    /**
     * Authenticates a user and generates a JWT token.
     * <p>
     * This method handles HTTP POST requests for user authentication. It authenticates the user with the provided
     * username and password, generates a JWT token for the authenticated user, and returns the token in a JwtResponse.
     * </p>
     *
     * @param loginDto the data transfer object containing the username and password for authentication
     * @return a ResponseEntity containing a JwtResponse with the generated JWT token, or an error message if authentication fails
     */
    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginDto loginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginDto.getUsername(), 
                    loginDto.getPassword()
                )
            );

            String jwt = jwtTokenProvider.createToken(authentication.getName(), authentication.getAuthorities());
            return ResponseEntity.ok(new JwtResponse(jwt));
        } catch (Exception e) {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginDto.getUsername(), 
                    loginDto.getPassword()
                )
            );
            return ResponseEntity.badRequest().body("Invalid username/password supplied"+ authentication);
        }
    }
}
