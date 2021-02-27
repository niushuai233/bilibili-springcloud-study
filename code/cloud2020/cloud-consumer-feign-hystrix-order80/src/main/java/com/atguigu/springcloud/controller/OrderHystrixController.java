package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ns
 * @date 2021/2/24
 */
@Slf4j
@RestController
@RequestMapping("/consumer/payment")
@DefaultProperties(defaultFallback = "globalDefaultFallback")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") String id) {

        return paymentHystrixService.paymentInfo_OK(id) + " from port " + port;
    }

    @GetMapping("/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutFallback", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
//    })
    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id") String id) {

//        int age = 10 / 0;

        return paymentHystrixService.paymentInfo_Timeout(id) + " from port " + port;
    }

    public String paymentInfo_TimeoutFallback(@PathVariable("id") String id) {

        return "消费端fallback处理 id = " + id;
    }

    public String globalDefaultFallback() {

        return "globalDefaultFallback 消费端fallback处理 id = ";
    }

}
