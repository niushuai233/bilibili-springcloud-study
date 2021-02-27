package com.atguigu.springcloud.config;

import com.atguigu.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author ns
 * @date 2021/2/27
 */
@Component
public class PaymentHystrixFallbackConfig implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(String id) {
        return "PaymentHystrixFallbackConfig paymentInfo_OK fallback";
    }

    @Override
    public String paymentInfo_Timeout(String id) {
        return "PaymentHystrixFallbackConfig paymentInfo_Timeout fallback";
    }
}
