package com.itiandou.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发送消息
 *
 * @Author : WenBao
 * Date : 17:24 2017/12/12
 */
@Component
public class HelloSender {
    //直接注入模板 springboot帮我们集成的模板
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        System.err.print("发送消息");
        rabbitTemplate.convertAndSend("directExchange","queue", "hello,rabbit");
    }

}
