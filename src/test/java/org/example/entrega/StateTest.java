package org.example.entrega;

import org.example.entrega.model.Cliente;
import org.example.entrega.model.Pedido;
import org.example.entrega.state.PedidoEstadoCriado;
import org.example.entrega.state.PedidoEstadoEmPreparacao;
import org.example.entrega.state.PedidoEstadoEntregue;
import org.example.entrega.state.PedidoEstadoSaiuParaEntrega;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StateTest {

    @Test
    void deveAlterarEstadoParaCriado() {
        Pedido pedido = new Pedido(new Cliente("A", "a@a"), 50.0f);
        pedido.setEstado(PedidoEstadoCriado.getInstance());

        assertEquals("Criado", pedido.getNomeEstado());
    }

    @Test
    void deveAlterarEstadoParaEmPreparacao() {
        Pedido pedido = new Pedido(new Cliente("B", "b@b"), 80.0f);
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());

        assertEquals("Em Preparacao", pedido.getNomeEstado());
    }

    @Test
    void deveAlterarEstadoParaSaiuParaEntrega() {
        Pedido pedido = new Pedido(new Cliente("C", "c@c"), 90.0f);
        pedido.setEstado(PedidoEstadoSaiuParaEntrega.getInstance());

        assertEquals("Saiu para Entrega", pedido.getNomeEstado());
    }

    @Test
    void deveAlterarEstadoParaEntregue() {
        Pedido pedido = new Pedido(new Cliente("D", "d@d"), 120.0f);
        pedido.setEstado(PedidoEstadoEntregue.getInstance());

        assertEquals("Entregue", pedido.getNomeEstado());
    }

    @Test
    void naoDeveAvancarEstadoDepoisDeEntregue() {
        Pedido pedido = new Pedido(new Cliente("E", "e@e"), 40.0f);
        pedido.setEstado(PedidoEstadoEntregue.getInstance());

        boolean avancou = pedido.avancarEstado();

        assertFalse(avancou);
        assertEquals("Entregue", pedido.getNomeEstado());
    }

    @Test
    void deveCancelarEmQualquerEstadoExcetoEntregue() {
        Pedido pedido = new Pedido(new Cliente("F", "f@f"), 60.0f);
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());

        boolean cancelou = pedido.cancelar();

        assertTrue(cancelou);
        assertEquals("Cancelado", pedido.getNomeEstado());
    }

    @Test
    void naoDeveCancelarDepoisDeEntregue() {
        Pedido pedido = new Pedido(new Cliente("G", "g@g"), 70.0f);
        pedido.setEstado(PedidoEstadoEntregue.getInstance());

        boolean cancelou = pedido.cancelar();

        assertFalse(cancelou);
        assertEquals("Entregue", pedido.getNomeEstado());
    }
}
