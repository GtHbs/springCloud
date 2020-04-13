package com.springcloud.comsumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: 李昭
 * @Date: 2020/4/2 18:51
 */
@Configuration
public class ApplicationContextConfig {


    /**
     * 开启负载均衡:
     *  均衡策略:
     *      (1) RoundRobinRule:轮询
     *          具体算法:
     *              rest接口的第几次请求数 % 服务器集群数量 = 实际下标位置,每次重启后从1开始计数
     *      (2) RandomRule:随机
     *      (3) RetryRule:先按照RoundRobinRule测策略获取服务,如果获取失败则在指定时间内进行重试,获取可用服务
     *      (4) WeightedResponseTimeRule:响应速度越快的的权重越大,但是很容易造成忽略
     *      (5) BestAvailableRule:会先过滤掉多次访问故障而处于断路器跳闸的状态的服务,然后选择一个并发量最小的服务
     *      (6) AvailabilityFilterlingRule:先过滤掉故障实例,再选择并发量小的实例
     *      (7) ZoneAvoidanceRule:默认规则,符合判断server所在区域的性能和server的可用性选择服务器
     */
//    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
