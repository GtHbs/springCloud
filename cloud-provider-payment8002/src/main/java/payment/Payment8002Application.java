package payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * eureka保护机制
 * 为了使EurekaClient可以正常运行,但是client以及不可以的情况下,EurekaServer不会
 * 立刻将EurekaClient剔除
 * 自我保护机制:
 * 默认情况下,EurekaServer在一定时间内没有收到某个微服务的心跳,EurekaServer就会注销
 * 该服务,但是如果是网络的问题导致通信出现延迟,阻塞,就应该使用自我保护机制(自动进入)
 * 默认情况下,EurekaClient定时向EurekaServer发送心跳包,如果在90秒内没有收到,就会将其
 * 剔除,但是如果在90秒内有大量的心跳包没有收到,EurekaServer就会开启自我保护机制,不会剔除该服务
 *
 * 好死不如赖活着
 *
 * @author: 李昭
 * @Date: 2020/4/2 15:13
 */
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class Payment8002Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8002Application.class, args);
    }
}
