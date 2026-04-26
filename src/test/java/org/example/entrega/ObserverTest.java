package org.example.entrega;

import org.example.entrega.model.Cliente;
import org.example.entrega.model.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ObserverTest {

    @Test
    void deveNotificarClienteQuandoPedidoAtualizaEstado() {
        Cliente cliente = new Cliente("Fernando", "9999-9999");
        Pedido pedido = new Pedido(cliente, 100.0f);

        pedido.notificar("Pedido confirmado!");

        assertEquals("Pedido confirmado!", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarVariosClientes() {
        Pedido pedido = new Pedido(null, 50.0f);

        Cliente c1 = new Cliente("Cliente1", "1111");
        Cliente c2 = new Cliente("Cliente2", "2222");

        pedido.addObserver(c1);
        pedido.addObserver(c2);

        pedido.notificar("Pedido saiu para entrega");

        assertEquals("Pedido saiu para entrega", c1.getUltimaNotificacao());
        assertEquals("Pedido saiu para entrega", c2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarClienteNaoInscrito() {
        Pedido pedido = new Pedido(null, 30.0f);
        Cliente cliente = new Cliente("Lucas", "3333");

        pedido.notificar("Pedido alterado");

        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void deveRegistrarMensagemPadraoQuandoArgNaoEhString() {
        Cliente cliente = new Cliente("Joao", "7777");
        Pedido pedido = new Pedido(cliente, 200.0f);

        pedido.notificar(null);

        assertEquals("Atualizacao no pedido.", cliente.getUltimaNotificacao());
    }
}
