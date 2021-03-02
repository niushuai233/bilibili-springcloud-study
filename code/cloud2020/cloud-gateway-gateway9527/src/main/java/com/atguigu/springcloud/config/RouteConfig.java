package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ns
 * @date 2021/3/2
 */
@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator rl1(RouteLocatorBuilder routeLocatorBuilder) {

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_atguigu",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();

        routes.route("test",
                r -> r.path("/baidu").uri("https://www.baidu.com"))
            .route("testgoogle",
                    r -> r.path("/google").uri("https://www.google.com.hk"))
                .route("guowai", r -> r.path("/guoji").uri("http://news.baidu.com/guoji"))
                .build();

        return routes.build();
    }
}
