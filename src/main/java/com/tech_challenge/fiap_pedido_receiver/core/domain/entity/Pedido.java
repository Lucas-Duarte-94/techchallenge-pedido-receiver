package com.tech_challenge.fiap_pedido_receiver.core.domain.entity;

import com.tech_challenge.fiap_pedido_receiver.core.dto.ItemPedidoDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    List<ItemPedidoDTO> itens;
    String paymentInfo;
    String userId;
}


// status
// ABERTO
// FECHADO_COM_SUCESSO
// FECHADO_SEM_ESTOQUE
// FECHADO_SEM_CREDITO
// PAGO