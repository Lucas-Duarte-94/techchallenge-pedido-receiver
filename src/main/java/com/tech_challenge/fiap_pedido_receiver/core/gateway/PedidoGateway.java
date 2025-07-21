package com.tech_challenge.fiap_pedido_receiver.core.gateway;

import com.tech_challenge.fiap_pedido_receiver.core.domain.entity.Pedido;
import com.tech_challenge.fiap_pedido_receiver.core.dto.CreatePedidoDTO;

import java.util.List;

public interface PedidoGateway {
    void createPedido(CreatePedidoDTO createPedidoDTO);
    Pedido findPedido(String idPedido);
    List<Pedido> findPedidos_byUserId(String userId);
}
