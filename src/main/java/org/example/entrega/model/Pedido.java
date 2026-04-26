package org.example.entrega.model;

import org.example.entrega.payment.PagamentoStrategy;
import org.example.entrega.state.PedidoEstado;
import org.example.entrega.state.PedidoEstadoCriado;

import java.util.Observable;
import java.util.concurrent.atomic.AtomicInteger;

public class Pedido extends Observable {

    private static final AtomicInteger SEQUENCIAL = new AtomicInteger(1);

    private final int id;
    private Cliente cliente;
    private PedidoEstado estado;
    private float total;
    private float valorPago;
    private PagamentoStrategy pagamentoStrategy;

    public Pedido(Cliente cliente, float total) {
        this.id = SEQUENCIAL.getAndIncrement();
        this.cliente = cliente;
        this.total = total;
        this.valorPago = 0.0f;
        this.estado = PedidoEstadoCriado.getInstance();

        if (cliente != null) {
            this.addObserver(cliente);
        }
    }

    public void notificar(Object mensagem) {
        setChanged();
        notifyObservers(mensagem);
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public void setEstado(PedidoEstado novoEstado) {
        this.estado = novoEstado;

        setChanged();
        notifyObservers(novoEstado.getEstado());
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public float getTotal() {
        return total;
    }

    public float getValorPago() {
        return valorPago;
    }

    public void setPagamentoStrategy(PagamentoStrategy strategy) {
        this.pagamentoStrategy = strategy;
    }

    public float aplicarPagamento(PagamentoStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy de pagamento nao informada.");
        }

        float pago = strategy.pagar(this.total);
        this.valorPago = pago;
        this.pagamentoStrategy = strategy;

        setChanged();
        notifyObservers("Pagamento realizado: R$ " + pago);

        return pago;
    }

    public boolean avancarEstado() {
        boolean mudou = this.estado.avancar(this);

        if (mudou) {
            setChanged();
            notifyObservers(this.estado.getEstado());
        }

        return mudou;
    }

    public boolean cancelar() {
        boolean cancelado = this.estado.cancelar(this);

        if (cancelado) {
            setChanged();
            notifyObservers("Pedido cancelado");
        }

        return cancelado;
    }
}
