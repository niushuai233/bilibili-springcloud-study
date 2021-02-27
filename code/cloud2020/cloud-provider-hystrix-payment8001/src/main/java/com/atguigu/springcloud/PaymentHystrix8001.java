package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ns
 * @date 2021/2/20
 */
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
public class PaymentHystrix8001 {

    public static void main(String[] args) {

        SpringApplication.run(PaymentHystrix8001.class, args);
    }
}
