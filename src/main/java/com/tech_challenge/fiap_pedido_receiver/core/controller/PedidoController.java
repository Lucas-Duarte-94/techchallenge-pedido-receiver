package com.tech_challenge.fiap_pedido_receiver.core.controller;

import com.tech_challenge.fiap_pedido_receiver.core.dto.CreatePedidoDTO;
import com.tech_challenge.fiap_pedido_receiver.core.gateway.PedidoGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
class PedidoController {
    private final PedidoGateway pedidoGateway;

    public PedidoController(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    @PostMapping
    public ResponseEntity<Void> createPedido(@RequestBody CreatePedidoDTO createPedidoDTO) {
        this.pedidoGateway.createPedido(createPedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}