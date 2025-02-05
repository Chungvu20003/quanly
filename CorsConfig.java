package com.example.quanlynhansu.quanLynhansu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:8080")  // Đảm bảo bạn chỉ định đúng địa chỉ frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
