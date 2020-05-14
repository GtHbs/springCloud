package com.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: 李昭
 * @Date: 2020/5/14 21:16
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClient {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClient.class, args);
    }
}
