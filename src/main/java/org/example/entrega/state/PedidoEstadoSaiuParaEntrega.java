package org.example.entrega.state;

import org.example.entrega.model.Pedido;

public class PedidoEstadoSaiuParaEntrega implements PedidoEstado {

    private static final PedidoEstadoSaiuParaEntrega instance = new PedidoEstadoSaiuParaEntrega();

    private PedidoEstadoSaiuParaEntrega() {}

    public static PedidoEstadoSaiuParaEntrega getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Saiu para Entrega";
    }

    @Override
    public boolean avancar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}
