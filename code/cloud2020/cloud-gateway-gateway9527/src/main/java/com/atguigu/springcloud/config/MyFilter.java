package com.atguigu.springcloud.config;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ns
 * @date 2021/3/2
 */
@Slf4j
@Order(1)
@Component
public class MyFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String username = exchange.getRequest().getQueryParams().getFirst("username");
        log.info("username: {}", username);
        if (!"niushuai233".equals(username)) {
            ServerHttpResponse response = exchange.getResponse();

            Map<String, Object> map = new HashMap<>();
            map.put("username", username);
            map.put("timestamp", DateUtil.now());

            DataBuffer dataBuffer = response.bufferFactory().wrap(JSONUtil.toJsonStr(map).getBytes(StandardCharsets.UTF_8));

            response.getHeaders().set("Content-Type", "application/json;charset=UTF-8");

            response.setStatusCode(HttpStatus.PRECONDITION_REQUIRED);
            return response.writeWith(Mono.just(dataBuffer));
        }

        return chain.filter(exchange);
    }
}
