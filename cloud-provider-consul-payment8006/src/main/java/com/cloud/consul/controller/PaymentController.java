package com.cloud.consul.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author: 李昭
 * @Date: 2020/4/4 16:11
 */
@RestController
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;

    /**
     *
     * @return
     */
    @GetMapping("/consul/payment")
    public String consulPayment() {
        return "SpringCloud Consul:" + serverPort +" " + UUID.randomUUID().toString().substring(0,10);
    }
}
