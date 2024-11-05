package com.forum.apigateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthGatewayFilter implements GatewayFilter {

    private final WebClient.Builder webClientBuilder;

    public JwtAuthGatewayFilter(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        if (token == null || !token.startsWith("Bearer ")) {
            return Mono.error(new RuntimeException("Missing or invalid Authorization header"));
        }

        // Сначала проверим токен через `validate-token` endpoint
        return webClientBuilder.build()
                .post()
                .uri("http://user-service:8084/api/validate-token")
                .header(HttpHeaders.AUTHORIZATION, token)
                .retrieve()
                .bodyToMono(Void.class)
                .then(
                        // После проверки токена извлекаем userId
                        webClientBuilder.build()
                                .post()
                                .uri("http://user-service:8084/api/extract-user-id")
                                .header(HttpHeaders.AUTHORIZATION, token)
                                .retrieve()
                                .bodyToMono(String.class)
                                .flatMap(userId -> {
                                    // Добавляем userId в заголовок запроса
                                    ServerWebExchange modifiedExchange = exchange.mutate()
                                            .request(exchange.getRequest().mutate()
                                                    .header("X-User-Id", userId)
                                                    .build())
                                            .build();
                                    return chain.filter(modifiedExchange);
                                })
                )
                .onErrorResume(error -> Mono.error(new RuntimeException("Token validation failed or extraction error", error)));
    }

}

