package org.example.entrega.state;

import org.example.entrega.model.Pedido;

public interface PedidoEstado {
    String getEstado();

    boolean avancar(Pedido pedido);


    boolean cancelar(Pedido pedido);
}
