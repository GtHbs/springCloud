package com.cloud.consul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: 李昭
 * @Date: 2020/4/4 16:30
 */
@SuppressWarnings("all")
@RestController
public class ConsulConsumerController {


    @Autowired
    private RestTemplate restTemplate;

    private static final String URL = "http://consul-provider-payment";


    @GetMapping("/consul/payment/get")
    public String payment() {
        String result = restTemplate.getForObject(URL + "/consul/payment", String.class);
        return result;
    }

}
