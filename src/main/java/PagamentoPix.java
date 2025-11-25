public class PagamentoPix implements PagamentoStrategy {

    public PagamentoPix() {}

    @Override
    public float pagar(float valorTotal) {
        return valorTotal;
    }
}
