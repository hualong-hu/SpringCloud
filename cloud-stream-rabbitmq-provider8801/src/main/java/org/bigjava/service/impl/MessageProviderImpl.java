package org.bigjava.service.impl;

import org.bigjava.service.IMessageProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 *  不是和controller打交道的service,而是发送消息的推送服务类
 *  @ProjectName: SpringCloud
 * @ClassName: MessageProviderImpl
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-29 17:00
 * @Version v1.0
 */
//定义消息的推送管道
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    //消息发送管道
    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();

        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("serial =============> " + serial);
        return null;
    }
}
