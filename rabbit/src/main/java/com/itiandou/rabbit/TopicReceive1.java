package com.itiandou.rabbit;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * https://www.cnblogs.com/chenfangzhi/p/9710698.html
 */
@Slf4j
@Component
public class TopicReceive1 {

    @RabbitListener(queues = "topic-1")
    public void getMessage(String message) {
        System.err.println("Topic1" + message);
    }


   /* @RabbitListener(bindings = {
            @QueueBinding(value = @Queue(value = "com.yjp.topic.rabbit.rooting.test1.add", durable = "true",autoDelete = "false"),
                    exchange = @Exchange(value = "com.yjp.topic.rabbit.exchange.test1", type = ExchangeTypes.TOPIC, durable = "true"), key = "com.yjp.topic.rabbit.rooting.test1.*"),
            @QueueBinding(value = @Queue(value = "iot.order.topic.tenant.rooting.only.add", durable = "true"),
                    exchange = @Exchange(value = "iot.order.tenant.topic.exchange.add", type = ExchangeTypes.TOPIC, durable = "true"), key = "iot.order.topic.tenant.rooting.only.add")
    })*/
    public void mqIotTracing1(String content) {
        log.info("【溯源消费者】--【{}】----com.yjp.rabbitmq.TopicReceive1：+mqIotTracing1() start ,into parameters {}.", Thread.currentThread().getName(), content);
        log.info("{}",content);
        log.info("【溯源消费者】--【{}】----com.yjp.rabbitmq.TopicReceive1：+mqIotTracing1() end ,process result {}.", Thread.currentThread().getName());
    }
    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue(value = "com.yjp.topic.rabbit.rooting.test1.delete", durable = "true",autoDelete = "false"),
                    exchange = @Exchange(value = "com.yjp.topic.rabbit.exchange.test1", type = ExchangeTypes.TOPIC, durable = "true" ), key = "com.yjp.topic.rabbit.rooting.test1.*"),
            @QueueBinding(value = @Queue(value = "iot.order.topic.tenant.rooting.only.add", durable = "true"),
                    exchange = @Exchange(value = "iot.order.tenant.topic.exchange.add", type = ExchangeTypes.TOPIC, durable = "true"), key = "iot.order.topic.tenant.rooting.only.add")
    })
    public void mqIotTracing2(Message message, String content, Channel channel , @Header("amqp_redelivered") boolean redelivered) {
        log.info("【溯源消费者】--【{}】----com.yjp.rabbitmq.TopicReceive1：+mqIotTracing2() start ,into parameters {}.", Thread.currentThread().getName(), content);
        log.info("{}---{}",content  );
        /*try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
            //这一步千万不要忘记，不会会导致消息未确认，消息到达连接的qos之后便不能再接收新消息
            //一般重试肯定的有次数，这里简单的根据是否已经重发过来来决定重发。第二个参数表示是否重新分发
            try {
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), !redelivered);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }*/
        log.info("【溯源消费者】--【{}】----com.yjp.rabbitmq.TopicReceive1：+mqIotTracing2() end ,process result {}.", Thread.currentThread().getName());
    }
}
