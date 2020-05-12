package com.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: 李昭
 * @Date: 2020/5/12 20:23
 */
@RestController
public class NacosConsumerController {

    @Resource
    RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @GetMapping("/consumer/payment/{id}")
    public String paymentInfo(@PathVariable("id")Integer id) {
        return restTemplate.getForObject(serviceUrl+"/payment/getPayment/"+id,String.class);
    }

}
