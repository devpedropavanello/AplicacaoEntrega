public class ProcessadorPagamento {

    public float processarPagamento(PagamentoStrategy strategy, float valorTotal) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy de pagamento não informada.");
        }
        return strategy.pagar(valorTotal);
    }
}
