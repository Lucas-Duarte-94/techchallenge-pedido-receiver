package com.tech_challenge.fiap_pedido_receiver.core.controller;

import com.tech_challenge.fiap_pedido_receiver.core.domain.entity.Pedido;
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
    public ResponseEntity<Pedido> createPedido(@RequestBody CreatePedidoDTO createPedidoDTO) {
        var pedido = this.pedidoGateway.createPedido(createPedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

}