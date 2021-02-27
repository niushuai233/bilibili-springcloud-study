package com.atguigu.springcloud.service;

/**
 * @author ns
 * @date 2021/2/24
 */
public interface PaymentService {


    String paymentInfo_OK(String id);

    String paymentInfo_Timeout(String id);
}
