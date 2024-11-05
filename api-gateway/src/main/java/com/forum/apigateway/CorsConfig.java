package com.forum.apigateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOriginPatterns(Arrays.asList("http://localhost:8085", "http://localhost:8082", "http://localhost:8084")); // Замените на ваши домены
        corsConfig.addAllowedHeader("*"); // Разрешаем все заголовки
        corsConfig.addAllowedMethod("*"); // Разрешаем все методы
        corsConfig.setAllowCredentials(true); // Разрешаем отправку cookie и данных аутентификации

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig); // Применить ко всем маршрутам

        return new CorsWebFilter(source);
    }
}

