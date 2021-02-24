package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save")
    public CommonResult save(@RequestBody Payment payment) {

        int result = paymentService.save(payment);

        log.info("save payment: {} res: {}", payment.getSerial(), result);

        if (result > 0) {
            return new CommonResult(200, "success", result);
        }

        return new CommonResult<Payment>(444, "插入失败");
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {

        log.info("req id: {}", id);

        Payment payment = paymentService.getPaymentById(id);

        log.info("select payment: {}", payment);
        if (payment != null) {
            return new CommonResult(200, "success", payment);
        }

        return new CommonResult<Payment>(445, "未找到记录");
    }
}
