package com.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloud.alibaba.handler.CustomerBlockHandler;
import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 李昭
 * @Date: 2020/5/18 20:19
 */
@RestController
public class RateLimitController {

    /**
     * 按照资源名进行限流访问
     *
     * @return
     */
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试", new Payment(2020L, "serial0"));
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(404, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    /**
     * 按资源路径进行限流访问
     *
     * @return
     */
    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按资源路径限流测试", new Payment(2020L, "serial1"));
    }

    @GetMapping("/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "自定义限流处理", new Payment(2020L, "serial2"));
    }

}
