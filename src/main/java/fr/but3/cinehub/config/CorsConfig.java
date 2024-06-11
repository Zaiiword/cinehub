package fr.but3.cinehub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Configuration class for Cross-Origin Resource Sharing (CORS).
 * <p>
 * This class provides a method to create a CORS filter with specific configurations.
 * </p>
 */
@Configuration
public class CorsConfig {

    /**
     * Creates a CORS filter with specific configurations.
     * <p>
     * The configurations allow certain origins, headers, and methods.
     * Replace "*" with the URL of your front-end.
     * </p>
     * @return a CorsFilter object with the specified configurations.
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:8000");
        config.addAllowedOrigin("http://localhost:8081");
        config.addAllowedOrigin("http://cinehub.ovh");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}