package com.cloud.hystrix.service;

import org.springframework.stereotype.Service;

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

    public String getPaymentInfoTimeout(Long id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo-timeout-id:" + id;
    }

}
