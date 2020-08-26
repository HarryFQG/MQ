package com.itiandou.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sender() {
        System.err.println("消息发送");
        //如果不写"" 那么fanoutExchange这个exchange会默认成为routingkey
        rabbitTemplate.convertAndSend("fanoutExchange", "", "你好");
    }
}
