package com.tech_challenge.fiap_pedido_receiver.core.usecase;

import com.tech_challenge.fiap_pedido_receiver.core.domain.entity.Pedido;
import com.tech_challenge.fiap_pedido_receiver.core.dto.CreatePedidoDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CreatePedidoUseCaseRabbitMQ implements CreatePedidoUseCase {

    private final RabbitTemplate rabbitTemplate;

    @Value("${app.rabbitmq.exchange:order.exchange}")
    private String exchangeName;

    @Value("${app.rabbitmq.routing-key:order.notification}")
    private String routingKey;

    public CreatePedidoUseCaseRabbitMQ(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public Pedido createPedido(CreatePedidoDTO createPedidoDTO) {
        try {
            var pedido = Pedido.builder()
                .itens(createPedidoDTO.pedidos())
                .userId(createPedidoDTO.userID())
                .paymentInfo(createPedidoDTO.paymentInfo())
                .build();

            rabbitTemplate.convertAndSend(exchangeName, routingKey, pedido);

            return pedido;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
