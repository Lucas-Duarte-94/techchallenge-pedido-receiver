package com.tech_challenge.fiap_pedido_receiver.core.usecase;

import com.tech_challenge.fiap_pedido_receiver.core.dto.CreatePedidoDTO;
import com.tech_challenge.fiap_pedido_receiver.core.gateway.PedidoGateway;
import org.springframework.stereotype.Service;

@Service
public class PedidoImplementation implements PedidoGateway {
    private final CreatePedidoUseCase createPedidoUseCase;

    public PedidoImplementation(CreatePedidoUseCase createPedidoUseCase) {
        this.createPedidoUseCase = createPedidoUseCase;
    }

    @Override
    public void createPedido(CreatePedidoDTO createPedidoDTO) {
        this.createPedidoUseCase.createPedido(createPedidoDTO);
    }
}
