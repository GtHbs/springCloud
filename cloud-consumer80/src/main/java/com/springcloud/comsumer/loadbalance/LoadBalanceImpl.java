package com.springcloud.comsumer.loadbalance;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: 李昭
 * @Date: 2020/4/4 20:25
 */
@Component
public class LoadBalanceImpl implements LoadBalancer {

    /**
     * 用于存储服务器数量
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);


    @Override
    public ServiceInstance instance(List<ServiceInstance> instances) {
        int index = getAndIncrement() % instances.size();
        return instances.get(index);
    }


    //自增算法
    private final Integer getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current,next));
        System.out.println("-------------"+next+"------------");
        return next;
    }
}
