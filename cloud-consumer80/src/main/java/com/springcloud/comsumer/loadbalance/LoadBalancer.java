package com.springcloud.comsumer.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义负载算法
 *
 * @author: 李昭
 * @Date: 2020/4/4 20:23
 */
public interface LoadBalancer {

    /**
     * 获取所有的服务实例
     *
     * @param instances
     * @return
     */
    ServiceInstance instance(List<ServiceInstance> instances);


}
