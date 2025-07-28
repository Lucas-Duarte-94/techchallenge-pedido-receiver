package com.tech_challenge.fiap_pedido_receiver.core.usecase;

import com.tech_challenge.fiap_pedido_receiver.core.dto.CreatePedidoDTO;
import com.tech_challenge.fiap_pedido_receiver.core.dto.CreditCardRequestDTO;
import com.tech_challenge.fiap_pedido_receiver.core.dto.ItemPedidoDTO;
import com.tech_challenge.fiap_pedido_receiver.core.dto.PaymentInfoDTO;
import com.tech_challenge.fiap_pedido_receiver.core.dto.PaymentMethod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.mockito.Mockito.verify;

class CreatePedidoUseCaseRabbitMQTest {

    @Mock
    private RabbitTemplate rabbitTemplate;

    @InjectMocks
    private CreatePedidoUseCaseRabbitMQ createPedidoUseCaseRabbitMQ;

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        MockitoAnnotations.openMocks(this);
        createPedidoUseCaseRabbitMQ = new CreatePedidoUseCaseRabbitMQ(rabbitTemplate);

        // Use reflection to set the private fields annotated with @Value
        java.lang.reflect.Field exchangeNameField = CreatePedidoUseCaseRabbitMQ.class.getDeclaredField("exchangeName");
        exchangeNameField.setAccessible(true);
        exchangeNameField.set(createPedidoUseCaseRabbitMQ, "order.exchange");

        java.lang.reflect.Field routingKeyField = CreatePedidoUseCaseRabbitMQ.class.getDeclaredField("routingKey");
        routingKeyField.setAccessible(true);
        routingKeyField.set(createPedidoUseCaseRabbitMQ, "order.notification");
    }

    @Test
    void testCreatePedido() {
        ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO("SKU123", 1);
        CreditCardRequestDTO creditCardRequestDTO = new CreditCardRequestDTO("1234567890123456", "123", "Test User", "12/25");
        PaymentInfoDTO paymentInfoDTO = new PaymentInfoDTO("pedido123", new java.math.BigDecimal("100.00"), PaymentMethod.CARTAO, creditCardRequestDTO);
        CreatePedidoDTO createPedidoDTO = new CreatePedidoDTO(java.util.Collections.singletonList(itemPedidoDTO), "user123", paymentInfoDTO);
        createPedidoUseCaseRabbitMQ.createPedido(createPedidoDTO);
        verify(rabbitTemplate).convertAndSend("order.exchange", "order.notification", createPedidoDTO);
    }
}