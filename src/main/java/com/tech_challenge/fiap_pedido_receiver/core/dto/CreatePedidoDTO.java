package com.tech_challenge.fiap_pedido_receiver.core.dto;

import java.util.List;

public record CreatePedidoDTO(
                List<ItemPedidoDTO> pedidos,
                String userID,
                String paymentInfo) {
}