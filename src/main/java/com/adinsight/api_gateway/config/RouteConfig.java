package com.adinsight.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("advertiser-service", r -> r.path("/api/advertiser/**")
                        .uri("http://localhost:8081"))
                .route("analytics-service", r -> r.path("/api/analytics/**")
                        .uri("http://localhost:8082"))
                .build();
    }
}