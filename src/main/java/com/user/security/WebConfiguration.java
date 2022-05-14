package com.user.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.print(registry);
        registry.addMapping("/**").allowedOrigins("*");
        registry.addMapping("/**").allowedOrigins("http://taxcalculator-frontend.s3-website-us-west-1.amazonaws.com/");
    }
}