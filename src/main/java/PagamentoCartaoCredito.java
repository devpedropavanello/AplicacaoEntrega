public class PagamentoCartaoCredito implements PagamentoStrategy {

    private float taxaPercentual;

    public PagamentoCartaoCredito() {
        this.taxaPercentual = 2.5f;
    }

    public PagamentoCartaoCredito(float taxaPercentual) {
        this.taxaPercentual = taxaPercentual;
    }

    @Override
    public float pagar(float valorTotal) {
        float taxa = valorTotal * (taxaPercentual / 100.0f);
        return valorTotal + taxa;
    }
}
