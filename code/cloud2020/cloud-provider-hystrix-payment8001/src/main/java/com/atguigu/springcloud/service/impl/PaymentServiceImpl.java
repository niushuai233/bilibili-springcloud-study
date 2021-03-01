package com.atguigu.springcloud.service.impl;

import cn.hutool.core.date.DateUtil;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.commons.lang.StringUtils;
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


    //  服务熔断

    @Override
    @HystrixCommand(fallbackMethod = "payment_circuitBreaker_fallback", commandProperties = {
            // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 请求窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 请求失败百分比
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String payment_circuitBreaker(Integer id) {

        if (id < 0) {
            throw new RuntimeException("id不能为负数 id = " + id);
        }

        return DateUtil.now() + "payment_circuitBreaker 成功啦 return id = " + id;
    }

    public String payment_circuitBreaker_fallback(Integer id) {

        return "payment_circuitBreaker_fallback 失败啦 return id = " + id;
    }

}
