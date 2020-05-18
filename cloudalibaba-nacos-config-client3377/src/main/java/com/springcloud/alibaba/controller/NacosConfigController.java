package com.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 李昭
 * @Date: 2020/5/14 21:17
 */
//不要使用下面的注解,否则不能从配置中心获取配置信息
//@RefreshScope
@RestController
public class NacosConfigController {


    @Value("${config.info}")
    private String configInfo;

    @RequestMapping("/config/info")
    private String getConfigInfo() {
        System.out.println(configInfo);
        return configInfo;
    }
}
