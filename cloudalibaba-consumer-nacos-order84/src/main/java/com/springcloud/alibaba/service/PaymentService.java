package com.springcloud.alibaba.service;

import com.springcloud.alibaba.fallback.PaymentFallbackService;
import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: 李昭
 * @Date: 2020/5/19 22:10
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @RequestMapping(value = "/payment/{id}")
    public CommonResult<Payment> paymentCommonResult(@PathVariable("id")Long id);
}
