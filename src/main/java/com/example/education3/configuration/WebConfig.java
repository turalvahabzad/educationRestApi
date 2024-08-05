package com.example.education3.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")     // Butun url lerler icaze ver
                .allowedOrigins("*")           // Butun originler eicaze ver
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // istediyiniz methodlara icaze ver
                .allowedHeaders("*");    // Butun headerlere icaze ver
    }
}
