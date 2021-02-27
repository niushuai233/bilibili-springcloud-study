package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author ns
 * @date 2021/2/24
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfo_OK(String id) {

        return "线程池：" + Thread.currentThread().getName() + "\t paymentInfo_OK\tid=" + id;
    }

    @Override
    public String paymentInfo_Timeout(String id) {

        int timeNumber = 3;

        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池：" + Thread.currentThread().getName() + "\t paymentInfo_Timeout\tid=" + id + "\t耗时: " + timeNumber + "s";
    }
}
