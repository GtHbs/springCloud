package com.springcloud.payment.serviceimpl;

import com.springcloud.entities.Payment;
import com.springcloud.payment.repository.PaymentRepository;
import com.springcloud.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 李昭
 * @Date: 2020/4/2 15:45
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Override
    public Integer create(Payment payment) {
        int i = repository.create(payment);
        return i;
    }

    @Override
    public Payment getPaymentById(Long id) {
        Payment payment = repository.getPaymentById(id);
        return payment;
    }
}
