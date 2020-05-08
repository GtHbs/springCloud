package com.springcloud.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

/**
 * @author: 李昭
 * @Date: 2020/5/8 21:15
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

}
