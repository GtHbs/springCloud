package com.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.springcloud.alibaba.service.PaymentService;
import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: 李昭
 * @Date: 2020/5/19 21:14
 */
@RestController
public class NacosConsumerController {

    public static final String SERVICE_URL = "http://nacos-payment-provicer";

    @Resource
    private RestTemplate restTemplate;

    /**
     * 如果同时配置了限流和熔断,且同时触发熔断和限流会优先进入限流中
     *
     * @param id
     * @return
     */
    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")
//    @SentinelResource(value = "fallback", fallback = "handlerFallback")
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler")
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler",
    exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(SERVICE_URL + "/payment/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("非法参数...");
        } else if (result.getData() == null) {
            throw new NullPointerException("没有对应记录");
        }
        return result;
    }

    /**
     * 熔断降级
     *
     * @param id
     * @param throwable
     * @return
     */
    public CommonResult handlerFallback(@PathVariable("id") Long id, Throwable throwable) {
        Payment payment = new Payment(1L, "null");
        return new CommonResult(500, "熔断方法,异常内容:" + throwable.getMessage(), payment);
    }

    public CommonResult blockHandler(@PathVariable("id") Long id, Throwable throwable) {
        Payment payment = new Payment(1L, "null");
        return new CommonResult(500, "请求异常方法,异常内容:" + throwable.getMessage(), payment);
    }


    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/openfeign/payment/{id}")
    public CommonResult<Payment> consumerPayment(@PathVariable("id")Long id) {
        return paymentService.paymentCommonResult(id);
    }
}
