package com.campusconnect.campusconnect_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Allowed Origins: Enable dynamic origin support
        config.setAllowedOrigins(List.of(
                "http://localhost:3000",          // For local development
                "https://campusconnect.com",      // Production domain
                "https://admin.campusconnect.com" // Admin panel domain (optional)
        ));

        // Allowed Methods: RESTful API Methods
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Allowed Headers: Required headers for JWT token-based authentication
        config.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));

        // Allow Credentials: This allows cookies, tokens, sessions, etc.
        config.setAllowCredentials(true);

        // Map the CORS configuration to all endpoints
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
