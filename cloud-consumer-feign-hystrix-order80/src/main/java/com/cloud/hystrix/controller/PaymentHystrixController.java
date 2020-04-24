package com.cloud.hystrix.controller;

import com.cloud.hystrix.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 李昭
 * @Date: 2020/4/15 21:12
 */
@SuppressWarnings("all")
@RestController
@Slf4j
/**
 *   定义全局熔断处理器(方法上配置的优先级要高于全局)
 *
 *   熔断和降级的区别:
 *      降级: 当调用服务出现错误时,会调用备用的接口,不会对整个服务造成影响
 *      熔断: 熔断是应对于雪崩效应的一种手段,当某个微服务出错或者响应时间太长的话,
 *           会对服务进行降级,从而熔断该节点的微服务调用,快速返回调用的信息,当检测
 *           到微服务调用正常后,会恢复调用链路
 */
@DefaultProperties(defaultFallback = "globalHystrixFallbackMethod")
public class PaymentHystrixController {

    @Autowired
    PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/info/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_Ok(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_Delay(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_Delay(id);
    }

    @GetMapping("/consumer/payment/hystrix/info/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethod",
//            commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//            })
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String s = paymentHystrixService.paymentInfo_Delay(id);
        return s;
    }

    public String paymentTimeoutFallbackMethod(@PathVariable("id") Integer id) {
        String message = "客户端调用熔断处理器";
        return message;
    }

    /**
     * 全局熔断处理器(该方法不能有参数)
     *
     * @param id
     * @return
     */
    public String globalHystrixFallbackMethod() {
        return "全局熔断处理器";
    }
}
