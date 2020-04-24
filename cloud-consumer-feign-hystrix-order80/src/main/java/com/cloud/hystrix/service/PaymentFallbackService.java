package com.cloud.hystrix.service;

import org.springframework.stereotype.Service;

/**
 * @author: 李昭
 * @Date: 2020/4/21 22:13
 */
@Service
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_Ok(Integer id) {
        return "PaymentFallbackService method fallback" + id;
    }

    @Override
    public String paymentInfo_Delay(Integer id) {
        return "PaymentFallbackService delay method fallback" + id;
    }
}
