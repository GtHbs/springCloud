package com.cloud.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: 李昭
 * @Date: 2020/4/4 16:27
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulConsumerApplicaton {

    public static void main(String[] args) {
        SpringApplication.run(ConsulConsumerApplicaton.class,args);
    }
}
