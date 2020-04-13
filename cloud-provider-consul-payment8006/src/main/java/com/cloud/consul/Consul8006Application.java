package com.cloud.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: 李昭
 * @Date: 2020/4/4 16:10
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Consul8006Application {

    public static void main(String[] args) {
        SpringApplication.run(Consul8006Application.class,args);
    }
}
