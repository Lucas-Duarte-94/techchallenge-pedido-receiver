package com.tech_challenge.fiap_pedido_receiver.core.usecase;

import com.tech_challenge.fiap_pedido_receiver.core.dto.CreatePedidoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CreatePedidoUseCaseRabbitMQ implements CreatePedidoUseCase {

    private final Logger logger = LoggerFactory.getLogger(CreatePedidoUseCaseRabbitMQ.class);

    private final RabbitTemplate rabbitTemplate;

    @Value("${app.rabbitmq.exchange:order.exchange}")
    private String exchangeName;

    @Value("${app.rabbitmq.queue:order.queue}")
    private String queueName;

    @Value("${app.rabbitmq.routing-key:order.notification}")
    private String routingKey;

    public CreatePedidoUseCaseRabbitMQ(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void createPedido(CreatePedidoDTO createPedidoDTO) {
        try {
            rabbitTemplate.convertAndSend(exchangeName, routingKey, createPedidoDTO);

            logger.info("Pedido created");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
