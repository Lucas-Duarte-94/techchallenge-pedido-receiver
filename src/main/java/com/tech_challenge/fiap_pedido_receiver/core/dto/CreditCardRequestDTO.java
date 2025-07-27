package com.tech_challenge.fiap_pedido_receiver.core.dto;

public record CreditCardRequestDTO(
        String creditCardNumber,
        String CVC,
        String ownerName,
        String validTo) {

}
