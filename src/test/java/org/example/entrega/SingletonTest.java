package org.example.entrega;

import org.example.entrega.model.Cliente;
import org.example.entrega.model.Pedido;
import org.example.entrega.service.PedidoGerenciador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class SingletonTest {

    @Test
    void deveRetornarMesmaInstancia() {
        PedidoGerenciador p1 = PedidoGerenciador.getInstancia();
        PedidoGerenciador p2 = PedidoGerenciador.getInstancia();

        assertSame(p1, p2);
    }

    @Test
    void deveAdicionarPedidosNaListaSingleton() {
        PedidoGerenciador ger = PedidoGerenciador.getInstancia();
        ger.limpar();

        Pedido p1 = new Pedido(new Cliente("Cliente 1", "c1@email.com"), 10.0f);
        ger.registrarPedido(p1);

        assertEquals(1, ger.getPedidos().size());
        assertEquals(p1, ger.getPedidos().get(0));
    }
}
