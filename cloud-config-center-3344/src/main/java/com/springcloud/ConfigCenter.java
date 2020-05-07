package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author: 李昭
 * @Date: 2020/5/7 20:54
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenter {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenter.class,args);
    }
}
