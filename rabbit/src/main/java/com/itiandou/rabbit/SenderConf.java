package com.itiandou.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 创建队列 队列名为queue
 *
 * @author : WenBao
 * date : 17:23 2017/12/12
 *
 */
@Configuration
public class SenderConf {
    //声明一个队列  direct模式队列
    @Bean
    public Queue direct() {
        return new Queue("queue", true);// true表示持久化该队列,注意对应的交换机也要是true，才能持久化，否则不行
    }


    //topic模式队列
    @Bean
    public Queue topic1() {
        return new Queue("topic-1");
    }

    //topic模式队列
    @Bean
    public Queue topic2() {
        return new Queue("topic-2");
    }

    //fanout模式队列
    @Bean
    public Queue fanout1() {
        return new Queue("fanout-1");
    }

    //fanout模式队列
    @Bean
    public Queue fanout2() {
        return new Queue("fanout-2");
    }


    /**
     * 声明交换机
     */
    @Bean
    TopicExchange topicExchange() {
        TopicExchange topicExchange = new TopicExchange("topicExchange");
        return topicExchange;
    }

    /**
     * 绑定  将队列和exchange绑定
     */
    @Bean
    public Binding bindingTopic1() {
        return BindingBuilder.bind(topic1()).to(topicExchange()).with("heyguys.dim.customer.#");
    }

    @Bean
    public Binding bindingTopic2() {
        return BindingBuilder.bind(topic2()).to(topicExchange()).with("*.123");
    }

    /**
     * 申明交换机
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    public Binding bindingfanout1() {
        return BindingBuilder.bind(fanout1()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingfanout2() {
        return BindingBuilder.bind(fanout2()).to(fanoutExchange());
    }


}
