package com.springcloud.alibaba.fallback;

import com.springcloud.alibaba.service.PaymentService;
import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author: 李昭
 * @Date: 2020/5/19 22:13
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentCommonResult(Long id) {
        return new CommonResult<>(444, "服务降级返回---PaymentFallbackService");
    }
}
