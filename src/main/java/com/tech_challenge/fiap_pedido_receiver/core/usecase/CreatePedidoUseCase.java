package com.tech_challenge.fiap_pedido_receiver.core.usecase;

import com.tech_challenge.fiap_pedido_receiver.core.dto.CreatePedidoDTO;

public interface CreatePedidoUseCase {
    void createPedido(CreatePedidoDTO createPedidoDTO);
}
