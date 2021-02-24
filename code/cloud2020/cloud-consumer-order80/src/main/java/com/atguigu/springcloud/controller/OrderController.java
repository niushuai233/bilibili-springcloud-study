package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author ns
 * @date 2021/2/24
 */
@Slf4j
@RestController
@RequestMapping("/consumer/payment")
public class OrderController {

    public static final String PAYMENT_URL = "http://localhost:8001";


    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/save")
    public CommonResult<Payment> save(Payment payment) {

        return restTemplate.postForObject(PAYMENT_URL + "/payment/save", payment, CommonResult.class);
    }


    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {

        return restTemplate.getForObject(PAYMENT_URL + "payment/get/" + id, CommonResult.class);
    }



}
