package com.ms.consumer.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer1 {

    public static final String QUEUE_NAME = "queue.example";

    @RabbitListener(queues = QUEUE_NAME)
    public void listenEmailQueue(@Payload String message) {
        System.out.println("Consumidor 1: " + message);
    }

}
