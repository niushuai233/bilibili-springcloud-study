package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ns
 * @date 2021/2/20
 */
@EnableEurekaClient
// 修改请求算法
// @RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MyselfRule.class)
//@RibbonClients(value = {@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MyselfRule.class)})
@SpringBootApplication
public class OrderMain80 {

    public static void main(String[] args) {

        SpringApplication.run(OrderMain80.class, args);
    }
}
