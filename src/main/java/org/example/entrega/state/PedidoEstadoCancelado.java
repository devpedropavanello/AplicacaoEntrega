package org.example.entrega.state;

import org.example.entrega.model.Pedido;

public class PedidoEstadoCancelado implements PedidoEstado {

    private static final PedidoEstadoCancelado instance = new PedidoEstadoCancelado();

    private PedidoEstadoCancelado() {}

    public static PedidoEstadoCancelado getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Cancelado";
    }

    @Override
    public boolean avancar(Pedido pedido) {
        return false;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        return false;
    }
}

