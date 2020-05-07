package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 如果远程配置文件中有端口配置,则客户端启动不会调用本地端口,会以远程端口进行启动
 *
 * @author: 李昭
 * @Date: 2020/5/7 21:40
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClient {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient.class,args);
    }
}
