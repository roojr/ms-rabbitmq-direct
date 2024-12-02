package com.ms.producer;

import com.ms.producer.config.RabbitMQProducerConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

	public final RabbitTemplate rabbitTemplate;

	@Value("${spring.rabbitmq.exchange.name}")
	private String exchangeName;

	@Value("${spring.rabbitmq.routing.name}")
	private String routingKey;

    public ProducerApplication(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public static void main(String[] args) {SpringApplication.run(ProducerApplication.class, args);}


	@Override
	public void run(String... args) {
		System.out.println("Enviando mensagem de teste...");
		rabbitTemplate.convertAndSend(exchangeName, routingKey,"Mensagem de teste 1");
		System.out.println("Mensagem enviada com sucesso...");
	}

}
