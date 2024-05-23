package fr.but3.cinehub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        // Create a new CORS configuration source
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
         // Set the allowed origins, headers, and methods for the CORS configuration
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://cinehub-front.s3-website-us-east-1.amazonaws.com"); // Remplacez "*" par l'URL de votre front-end
        config.addAllowedOrigin("http://localhost:8000"); 
        config.addAllowedOrigin("http://cinehub.ovh");
        config.addAllowedOrigin("http://cinehub.ovh.s3-website-us-east-1.amazonaws.com");  
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}