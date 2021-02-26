package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ns
 * @date 2021/2/26
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderZkMain80 {

    public static void main(String[] args) {

        SpringApplication.run(OrderZkMain80.class, args);
    }
}
