package com.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: 李昭
 * @Date: 2020/5/19 20:53
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelPayment9003 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelPayment9003.class,args);
    }
}
