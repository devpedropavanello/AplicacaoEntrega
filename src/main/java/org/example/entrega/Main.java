package org.example.entrega;

import org.example.entrega.model.Cliente;
import org.example.entrega.model.Pedido;
import org.example.entrega.payment.PagamentoPix;
import org.example.entrega.service.PedidoGerenciador;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Cliente Demo", "demo@entrega.com");
        Pedido pedido = new Pedido(cliente, 80.0f);

        pedido.aplicarPagamento(new PagamentoPix());
        PedidoGerenciador.getInstancia().registrarPedido(pedido);

        System.out.println("Pedido " + pedido.getId() + " criado para " + cliente.getNome());
        System.out.println("Estado atual: " + pedido.getNomeEstado());
        System.out.println("Pedidos registrados: " + PedidoGerenciador.getInstancia().getPedidos().size());
    }
}
