package com.springcloud.comsumer.controller;

import com.springcloud.comsumer.loadbalance.LoadBalancer;
import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import com.springcloud.entities.resultenum.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Objects;

/**
 * @author: 李昭
 * @Date: 2020/4/2 18:47
 */
@SuppressWarnings("all")
@RestController
@Slf4j
public class ConsumerController {
    /**
     * RestTemplate:
     * 提供了多种方式访问远程HTTP服务,是一种简单便捷访问restful服务模板类,
     * 是Spring提供用于访问Rest服务的客户端模板工具集
     */
    @Autowired
    private RestTemplate template;
    /**
     * 服务端对外暴露的服务地址,调用采用负载均衡
     */
    private static final String PAYMENT_URL = "http://cloud-provider-payment-service/";

    @Autowired
    private LoadBalancer loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;


    /**
     * 远程调用接口
     * @return
     */
    @GetMapping("/consumer/payment/lb")
    public String getPaymentLoadBalance() {
        //获取注册服务
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provider-payment-service");
        if(Objects.isNull(instances) || instances.size() <= 0) {
            return null;
        }
        ServiceInstance instance = loadBalancer.instance(instances);
        URI uri = instance.getUri();
        return template.getForObject(uri+"/payment/lb",String.class);
    }

    /**
     * 由模板调用并返回
     *
     * @param payment
     * @return
     */
    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return template.postForObject(PAYMENT_URL + "payment/create", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return template.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    /**
     * 返回Entity包括头信息和更多信息
     *
     * @param payment
     * @return
     */
    @PostMapping("/consumer/paymentEntity/create")
    public CommonResult<Payment> postPaymentBackEntity(Payment payment) {
        CommonResult result = template.postForEntity(PAYMENT_URL + "payment/create", payment, CommonResult.class).getBody();
        return result;
    }

    @GetMapping("/consumer/paymentEntity/get/{id}")
    public CommonResult<Payment> getPaymentEntity(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = template.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult<>(Result.FAIL.getCode(), Result.FAIL.getMessage());
        }
    }
}
