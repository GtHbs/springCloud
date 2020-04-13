package com.springcloud.payment.repository;

import com.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: 李昭
 * @Date: 2020/4/2 15:31
 */
@Repository
@Mapper
public interface PaymentRepository {
    /**
     * 添加
     *
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 查找
     *
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);
}
