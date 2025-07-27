package com.tech_challenge.fiap_pedido_receiver.core.dto;

import java.math.BigDecimal;

public record PaymentInfoDTO(
        String pedidoId,
        BigDecimal valor,
        PaymentMethod metodoPagamento,
        CreditCardRequestDTO creditCard) {

}
