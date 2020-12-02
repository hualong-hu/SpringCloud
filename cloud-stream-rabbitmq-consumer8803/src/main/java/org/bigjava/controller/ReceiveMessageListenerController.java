package org.bigjava.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: SpringCloud
 * @ClassName: ReceiveMessageListenerController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-29 17:18
 * @Version v1.0
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    //监听队列，用于消费者的队列的消息接收
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者2号，serverPort: " + serverPort + "，接受到的消息：" + message.getPayload());
    }
}
