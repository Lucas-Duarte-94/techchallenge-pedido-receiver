package com.tech_challenge.fiap_pedido_receiver.core.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQProducerConfig {

    @Value("${app.rabbitmq.exchange:order.exchange}")
    private String exchangeName;

//    @Value("${app.rabbitmq.queue:order.queue}")
//    private String queueName;
//
//    @Value("${app.rabbitmq.routing-key:order.notification}")
//    private String routingKey;

    @Bean
    public DirectExchange pedidoExchange() {
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}
