package com.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册服务中心
 *
 * Dubbo是个微服务整体架构的框架，提供的功能包括服务注册发现，远程调用，监控等等。
 * 对标的项目大概是spring cloud。Dubbo的服务发现模块基于zookeeper实现。
 * Eureka是spring cloud之下一个专门负责微服务服务注册和发现的组件，Eureka就是为了服务发现而设计的。
 * 是Dubbo对应的概念的一个部分。
 * Zookeeper是用来保证分布式一致性的一个软件。
 * 不是为了服务发现注册而设计的，只不过它的特性也可以被二次开发成服务发现注册中心罢了。
 *
 * @author: 李昭
 * @Date: 2020/4/3 15:52
 */
@EnableEurekaServer
@SpringBootApplication
public class Eureka7001Application {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7001Application.class,args);
    }
}
