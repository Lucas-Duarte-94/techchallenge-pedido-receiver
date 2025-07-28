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

import static org.mockito.Mockito.verify;

class PedidoImplementationTest {

    @Mock
    private CreatePedidoUseCase createPedidoUseCase;

    @InjectMocks
    private PedidoImplementation pedidoImplementation;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePedido() {
        ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO("SKU123", 1);
        CreditCardRequestDTO creditCardRequestDTO = new CreditCardRequestDTO("1234567890123456", "123", "Test User", "12/25");
        PaymentInfoDTO paymentInfoDTO = new PaymentInfoDTO("pedido123", new java.math.BigDecimal("100.00"), PaymentMethod.CARTAO, creditCardRequestDTO);
        CreatePedidoDTO createPedidoDTO = new CreatePedidoDTO(java.util.Collections.singletonList(itemPedidoDTO), "user123", paymentInfoDTO);
        pedidoImplementation.createPedido(createPedidoDTO);
        verify(createPedidoUseCase).createPedido(createPedidoDTO);
    }
}