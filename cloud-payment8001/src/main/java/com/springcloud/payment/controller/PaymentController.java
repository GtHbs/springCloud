package com.springcloud.payment.controller;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import com.springcloud.entities.resultenum.Result;
import com.springcloud.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author: 李昭
 * @Date: 2020/4/2 15:48
 */
@SuppressWarnings("all")
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    /**
     * 对外暴露服务
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        Integer result = paymentService.create(payment);
        log.info("********插入结果:#*********", result);
        if (result > 0) {
            return new CommonResult(Result.SUCCESS.getCode(), Result.SUCCESS.getMessage() + "->" + serverPort, result);
        } else {
            return new CommonResult(Result.FAIL.getCode(), Result.FAIL.getMessage() + "->" + serverPort, null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("******查询结果:#*******", payment);
        if (!Objects.isNull(payment)) {
            return new CommonResult(Result.SUCCESS.getCode(), Result.SUCCESS.getMessage() + "->" + serverPort, payment);
        } else {
            return new CommonResult(Result.FAIL.getCode(), Result.FAIL.getMessage() + "->" + serverPort, null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        Map<Object,Object> map = new HashMap<>();
        List<String> services = discoveryClient.getServices();
        for (String s : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(s);
            map.put(s,instances);
        }
        map.put("discoveryClient",discoveryClient);
        return map;
    }

    @GetMapping("/payment/lb")
    public String getServerPort() {
        return serverPort;
    }
}
