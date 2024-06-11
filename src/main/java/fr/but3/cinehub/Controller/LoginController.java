package fr.but3.cinehub.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.but3.cinehub.config.JwtTokenProvider;
import fr.but3.cinehub.entity.JwtResponse;
import fr.but3.cinehub.entity.LoginDto;

@RestController
@CrossOrigin(origins = "https://cinehub.ovh")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public LoginController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

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
