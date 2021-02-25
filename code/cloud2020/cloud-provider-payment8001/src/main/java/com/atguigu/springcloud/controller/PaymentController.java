package com.atguigu.springcloud.controller;

import cn.hutool.json.JSONUtil;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaServiceInstance;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ns
 * @date 2021/2/24
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private Integer port;

    @PostMapping("/save")
    public CommonResult save(@RequestBody Payment payment) {

        int result = paymentService.save(payment);

        log.info("save payment: {} res: {}", payment.getSerial(), result);

        if (result > 0) {
            return new CommonResult(200, "success from " + port, result);
        }

        return new CommonResult<Payment>(444, "插入失败");
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {

        log.info("req id: {}", id);

        Payment payment = paymentService.getPaymentById(id);

        log.info("select payment: {}", payment);
        if (payment != null) {
            return new CommonResult(200, "success from " + port, payment);
        }

        return new CommonResult<Payment>(445, "未找到记录");
    }

    @GetMapping("/discovery")
    public CommonResult discovery() {

        List<String> services = discoveryClient.getServices();


        for (String service : services) {

            List<ServiceInstance> instances = discoveryClient.getInstances(service);

            for (ServiceInstance instance : instances) {

                log.info("{} {} {} {} {}", instance.getInstanceId(), instance.getHost(), instance.getPort(), instance.getScheme(), instance.getUri());
            }

            log.info("service : {} complete", JSONUtil.toJsonStr(service));

        }


        return new CommonResult(200, "success", discoveryClient);
    }

}
