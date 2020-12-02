package org.bigjava.controller;

import org.bigjava.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ProjectName: SpringCloud
 * @ClassName: SendMessageController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-29 17:06
 * @Version v1.0
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }

}
