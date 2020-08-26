package com.itiandou.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceive1 {
    @RabbitListener(queues = "fanout-1")
    public void get(String message) {
        System.err.println(message);
    }
}
