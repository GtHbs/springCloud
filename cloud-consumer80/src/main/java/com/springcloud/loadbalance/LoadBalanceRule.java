package com.springcloud.loadbalance;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 负载均衡类不能与主启动类放在同一个目录下
 *
 * @author: 李昭
 * @Date: 2020/4/4 19:57
 */
@Configuration
public class LoadBalanceRule {

    /**
     * 定义为随机访问规则
     *
     * @return
     */
    @Bean
    public IRule randomRule() {
        return new RandomRule();
    }
}
