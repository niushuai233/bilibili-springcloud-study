package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
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
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private Integer port;


    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") String id) {

        return paymentService.paymentInfo_OK(id) + " from port " + port;
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") String id) {
        return paymentService.paymentInfo_Timeout(id) + " from port " + port;
    }

    @GetMapping("/hystrix/circualBreaker/{id}")
    public String payment_circuitBreaker(@PathVariable("id") Integer id) {
        return paymentService.payment_circuitBreaker(id) + " from port " + port;
    }
}
