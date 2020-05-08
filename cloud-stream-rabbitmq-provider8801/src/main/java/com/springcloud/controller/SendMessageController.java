package com.springcloud.controller;

import com.springcloud.service.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 李昭
 * @Date: 2020/5/8 21:06
 */
@RestController
public class SendMessageController {

    @Autowired
    private MessageProvider messageProvider;

    @RequestMapping("/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }

}
