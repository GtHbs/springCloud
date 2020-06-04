package com.springcloud.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 李昭
 * @Date: 2020/6/4 20:52
 */
@RestController
public class GatewayController {

    @Value("server.port")
    private String port;

    @RequestMapping("/monitor/{id}")
    public String getPort(@PathVariable("id") String id) {
        return "Gateway dispatcher -" + port + ":" + id;
    }
}
