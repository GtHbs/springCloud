package com.cloud.consul.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: 李昭
 * @Date: 2020/4/4 16:29
 */
@Configuration
public class RestTemplateConfiguration {


    /**
     * RestTemplate是基于HttpClient开发的,用于给Rest客户端发送请求
     *
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
