package com.itiandou.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceive2 {
    @RabbitListener(queues = "topic-2")
    public void getMessage(String message) {
        System.err.println("Topic2" + message);
    }
}
