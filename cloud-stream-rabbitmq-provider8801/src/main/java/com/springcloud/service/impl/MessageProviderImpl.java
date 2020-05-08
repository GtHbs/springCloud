package com.springcloud.service.impl;

import com.springcloud.service.MessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 绑定管道
 *
 * @author: 李昭
 * @Date: 2020/5/8 21:00
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements MessageProvider {

    @Resource
    private MessageChannel messageChannel;

    @Override
    public String send() {
        String serialId = UUID.randomUUID().toString();
        messageChannel.send(MessageBuilder.withPayload(serialId).build());
        return serialId;
    }
}
