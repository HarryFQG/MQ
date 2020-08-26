package com.itiandou.rabbit;

import com.alibaba.fastjson.JSON;
import com.itiandou.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class TopicSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private CountDownLatch downLatch = new CountDownLatch(10);

    @Value("${com.yjp.topic.rabbit.exchange}")
    private String exchange;

    @Value("${com.yjp.topic.rabbit.rooting.key}")
    private String rootingKey;

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public void send() {
        System.err.println("发送消息");
        //需要写上exchange的名字
        rabbitTemplate.convertAndSend("topicExchange", "consumer-index.999", "hello ni hao");
    }

    /**
     * 批量发送
     */
    public void batchSend() {
        log.info("TopicSender: +batchSend() start.");
        for (int j = 0; j < 10; j++) {
            log.info("j: {}", j);
            int finalJ = j;
            new Thread(() -> {
                downLatch.countDown();
                log.info("/// {}", downLatch.getCount());
                try {
                    downLatch.await();
                    for (int i = 0; i < 1; i++) {
                        Customer customer = new Customer(atomicInteger.addAndGet(1), Thread.currentThread().getName(), "" + i, System.currentTimeMillis());
                        rabbitTemplate.convertAndSend(exchange, rootingKey, JSON.toJSONString(customer));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }


        log.info("TopicSender: +batchSend() end.");
    }

}
