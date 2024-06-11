package fr.but3.cinehub.config;import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import jakarta.servlet.http.HttpServletResponse;

/**
 * This class provides the security configuration for the application.
 * <p>
 * It configures the security filter chain, password encoding, and session management.
 * It also sets up exception handling for authentication errors and authorizes requests.
 * </p>
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtTokenFilter jwtTokenFilter;

    /**
     * Constructs a new SecurityConfig with the given JwtTokenFilter.
     *
     * @param jwtTokenFilter the JwtTokenFilter to use
     */
    public SecurityConfig( JwtTokenFilter jwtTokenFilter) {
        this.jwtTokenFilter = jwtTokenFilter;
    }

    /**
     * Creates a PasswordEncoder bean.
     * <p>
     * This method returns a BCryptPasswordEncoder, which is a password encoder that uses the BCrypt strong hashing function.
     * </p>
     *
     * @return a BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configures the SecurityFilterChain.
     * <p>
     * This method sets up the security filter chain with CORS and CSRF disabled, stateless session management, 
     * exception handling for authentication errors, and request authorization.
     * It also adds the JwtTokenFilter before the UsernamePasswordAuthenticationFilter in the filter chain.
     * </p>
     *
     * @param http the HttpSecurity to configure
     * @return the configured SecurityFilterChain
     * @throws Exception if an error occurs during configuration
     */
    @SuppressWarnings({ "deprecation", "removal" })
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors().and().csrf().disable()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .exceptionHandling()
                .authenticationEntryPoint((request, response, ex) -> {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
                })
            .and()
            .authorizeRequests()
                .requestMatchers("/user/register","/login").permitAll()
                .anyRequest().authenticated()
            .and()
            .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    /**
     * Creates an AuthenticationManager bean.
     * <p>
     * This method returns an AuthenticationManager built from the provided AuthenticationConfiguration.
     * The AuthenticationManager can be used to authenticate a request within the application.
     * </p>
     *
     * @param authenticationConfiguration the AuthenticationConfiguration to use for creating the AuthenticationManager
     * @return the created AuthenticationManager
     * @throws Exception if an error occurs during the creation of the AuthenticationManager
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
