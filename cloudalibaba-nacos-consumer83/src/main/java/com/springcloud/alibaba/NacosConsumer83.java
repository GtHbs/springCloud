package com.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: 李昭
 * @Date: 2020/5/12 20:21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumer83 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumer83.class,args);
    }
}
