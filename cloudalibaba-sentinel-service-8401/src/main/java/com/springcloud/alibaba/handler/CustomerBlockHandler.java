package com.springcloud.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;

/**
 * @author: 李昭
 * @Date: 2020/5/18 20:41
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(202, "全局自定义限流处理", new Payment(2020L, "serial3"));
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(202, "全局自定义限流处理2", new Payment(2020L, "serial3"));
    }
}
