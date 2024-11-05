package com.forum.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder, JwtAuthGatewayFilter jwtAuthGatewayFilter) {

        return builder.routes()
                .route("user-service", r -> r.path("/api/authenticate", "/api/register", "/api/validate-token")
                        .uri("http://user-service:8084"))
                .route("user-service-profile", r -> r.path("/api/profile/**")  // Обработка всех маршрутов, начинающихся с /api/profile
                        .filters(f -> f.filter(jwtAuthGatewayFilter))
                        .uri("http://user-service:8084"))
                .route("secured-comments", r -> r.path("/api/comment")
                        .filters(f -> f.filter(jwtAuthGatewayFilter)) // Фильтр добавляет userId для комментариев
                        .uri("http://comment-service:8081"))
                .route("secured-scores", r -> r.path("/api/score")
                        .filters(f -> f.filter(jwtAuthGatewayFilter)) // Фильтр добавляет userId для комментариев
                        .uri("http://score-service:8086"))

                .build();
    }


}
