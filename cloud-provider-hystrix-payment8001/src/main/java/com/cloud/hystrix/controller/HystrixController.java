package com.cloud.hystrix.controller;

import com.cloud.hystrix.service.HystrixService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: 李昭
 * @Date: 2020/4/13 21:05
 */
@RestController
public class HystrixController {

    @Resource
    HystrixService service;

    @Value("${server.port}")
    String port;

    @GetMapping("/payment/hystrix/info/{id}")
    public String hystrixPaymentInfo(@PathVariable("id") Long id) {
        String info = service.getPaymentInfo(id);
        return info + ":" + port;
    }

    @GetMapping("/payment/hystrix/timeout/into/{id}")
    public String hystrixPaymentInfoTimeout(@PathVariable("id") Long id) {
        String timeout = service.getPaymentInfoTimeout(id);
        return timeout + ":" + port;
    }
}
