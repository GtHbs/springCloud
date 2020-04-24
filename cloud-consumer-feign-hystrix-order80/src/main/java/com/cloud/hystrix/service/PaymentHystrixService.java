package com.cloud.hystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
/**
    进行服务降级
 */
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    /**
     * 使用微服务接口调用
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/info/{id}")
    String paymentInfo_Ok(@PathVariable("id") Integer id);


    /**
     * 延时调用
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/into/{id}")
    String paymentInfo_Delay(@PathVariable("id") Integer id);
}
