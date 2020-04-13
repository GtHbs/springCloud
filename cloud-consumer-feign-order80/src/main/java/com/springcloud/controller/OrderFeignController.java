package com.springcloud.controller;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 李昭
 * @Date: 2020/4/8 20:53
 */
@RestController
public class OrderFeignController {

    @Autowired
    PaymentFeignService paymentFeignService;


    @GetMapping("/feign/getpayment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id) {
        CommonResult<Payment> result = paymentFeignService.getPaymentById(id);
        return result;
    }

    @GetMapping("/consumer/feign/delay")
    public String paymentFeignDelay() {
        String result = paymentFeignService.paymentFeignDelay();
        return result;
    }
}
