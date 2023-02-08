package com.iza.it.consumer;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfigMailConsumer {

    @Value("${queue.mail}")
    private String queueMail;

    @Bean
    public Queue createQueueMail() {
        return new Queue(queueMail, true);
    }
}
