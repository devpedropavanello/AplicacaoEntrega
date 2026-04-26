package org.example.entrega.payment;

public class PagamentoDinheiro implements PagamentoStrategy {

    public PagamentoDinheiro() {}

    @Override
    public float pagar(float valorTotal) {
        float descontoPercentual = 5.0f;
        float desconto = valorTotal * (descontoPercentual / 100.0f);
        return valorTotal - desconto;
    }
}
