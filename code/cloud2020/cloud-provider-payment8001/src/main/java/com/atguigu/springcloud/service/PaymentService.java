package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * @author ns
 * @date 2021/2/24
 */
public interface PaymentService {


    public int save(Payment payment);

    public Payment getPaymentById(Long id);
}
