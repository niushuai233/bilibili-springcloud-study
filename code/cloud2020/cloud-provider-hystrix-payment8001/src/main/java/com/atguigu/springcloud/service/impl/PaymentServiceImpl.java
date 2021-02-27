package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
    })
    public String paymentInfo_Timeout(String id) {

        int timeNumber = 1;

//        try {
//            TimeUnit.SECONDS.sleep(timeNumber);
//        } catch (InterruptedException e) {
//        }


//        int age = 10 / 0;
        return "线程池：" + Thread.currentThread().getName() + "\t paymentInfo_Timeout\tid=" + id + "\t耗时: " + timeNumber + "s";
    }

    public String paymentInfo_TimeoutHandler(String id) {
        return Thread.currentThread().getName() + " paymentInfo_TimeoutHandler 默认处理机制 id = " + id;
    }

}
