package com.cloud.hystrix.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: 李昭
 * @Date: 2020/4/13 21:00
 */
@Service
public class HystrixService {

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String getPaymentInfo(Long id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo-id:" + id;
    }


    /**
     * 熔断机制:
     * 当前方法报错时,调用备用的方法,注解属性为该线程最多执行3秒,否则调用备用方法
     * 只要当前线程超时或者出现异常,都会熔断,调用备用方法
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String getPaymentInfoTimeout(Long id) {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo-timeout-id:" + id;
    }

    public String paymentInfo_TimeoutHandler(Long id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo-timeout_fallback_method-id:" + id;
    }


    /*============================服务熔断=============================*/


    @HystrixCommand(fallbackMethod = "paymentCircuit_fallback", commandProperties = {
            //开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            /*
             * 触发熔断的最小次数(默认为20)
             * 只有在一段时间内请求次数达到20才会进行错误比例计算
             */
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            /*
             * 时间窗口期(范围),熔断10秒后尝试去请求
             * 默认为5秒，当熔断器打开后5秒后就会尝试放入一部分流量进行试探。确定依赖的服务是否恢复。
             *
             */
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),

            /*
             * 失败率达到60%(上面配置的10次)后就跳闸
             * 错误率：默认为50%
             * 只要在某段时间内或者达到固定次数的比例时，就会触发熔断
             */
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new IllegalArgumentException("id不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功,流水号: " + uuid;
    }


    public String paymentCircuit_fallback(@PathVariable("id") Integer id) {
        return "id 不能为负数-" + id;
    }

}
