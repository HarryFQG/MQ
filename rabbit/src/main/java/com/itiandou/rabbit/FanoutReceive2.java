package com.itiandou.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceive2 {
    @RabbitListener(queues = "fanout-2")
    public void get(String message) {
        System.err.println(message);
    }
}
