package com.springcloud.payment.service;

import com.springcloud.entities.Payment;

/**
 * @author: 李昭
 * @Date: 2020/4/2 15:44
 */
public interface PaymentService {
    /**
     * 查询
     *
     * @param id
     * @return
     */
    Payment getPaymentById(Long id);

    /**
     * 插入
     *
     * @param payment
     * @return
     */
    Integer create(Payment payment);
}
