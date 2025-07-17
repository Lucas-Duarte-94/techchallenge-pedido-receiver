package com.tech_challenge.fiap_pedido_receiver.core.usecase;

import com.tech_challenge.fiap_pedido_receiver.core.domain.entity.Pedido;
import com.tech_challenge.fiap_pedido_receiver.core.dto.CreatePedidoDTO;
import com.tech_challenge.fiap_pedido_receiver.core.gateway.PedidoGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoImplementation implements PedidoGateway {
    private final CreatePedidoUseCase createPedidoUseCase;

    public PedidoImplementation(CreatePedidoUseCase createPedidoUseCase) {
        this.createPedidoUseCase = createPedidoUseCase;
    }

    @Override
    public Pedido createPedido(CreatePedidoDTO createPedidoDTO) {
        return this.createPedidoUseCase.createPedido(createPedidoDTO);
    }

    @Override
    public Pedido findPedido(String idPedido) {
        return null;
    }

    @Override
    public List<Pedido> findPedidos_byUserId(String userId) {
        return List.of();
    }
}
