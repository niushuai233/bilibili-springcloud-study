package com.atguigu.springcloud.service;

import com.atguigu.springcloud.config.PaymentHystrixFallbackConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ns
 * @date 2021/2/27
 */
@Component
@FeignClient(value = "cloud-provider-hystrix-service", fallback = PaymentHystrixFallbackConfig.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") String id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_Timeout(@PathVariable("id") String id);
}