package com.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 李昭
 * @Date: 2020/5/12 20:12
 */
@RestController
@RequestMapping("/payment")
public class NacosProvider9002Controller {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/getPayment/{id}")
    public String getPort(@PathVariable("id")Integer id) {
        return port + id;
    }
}
