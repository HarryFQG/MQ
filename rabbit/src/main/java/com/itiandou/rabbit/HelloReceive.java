package com.itiandou.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloReceive {
    @RabbitListener(queues = "queue")
    public void process(String str) {
        System.err.println("Receive:" + str);
    }
}
