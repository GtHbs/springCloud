package com.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 李昭
 * @Date: 2020/4/13 20:28
 */
@Configuration
public class FeignConfig {

    /**
     * 使用Feign的日志打印,设置级别为全打印
     *
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
