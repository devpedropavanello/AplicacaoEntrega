package org.example.entrega.service;

import org.example.entrega.payment.PagamentoStrategy;

public class ProcessadorPagamento {

    public float processarPagamento(PagamentoStrategy strategy, float valorTotal) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy de pagamento nao informada.");
        }
        return strategy.pagar(valorTotal);
    }
}
