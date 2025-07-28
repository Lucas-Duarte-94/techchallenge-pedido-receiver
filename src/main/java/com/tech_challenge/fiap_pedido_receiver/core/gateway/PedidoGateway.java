package com.tech_challenge.fiap_pedido_receiver.core.gateway;

import com.tech_challenge.fiap_pedido_receiver.core.dto.CreatePedidoDTO;

public interface PedidoGateway {
    void createPedido(CreatePedidoDTO createPedidoDTO);
}
