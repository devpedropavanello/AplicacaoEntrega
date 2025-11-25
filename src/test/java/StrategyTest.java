import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrategyTest {

    @Test
    void deveAplicarPagamentoCredito() {
        Pedido pedido = new Pedido(new Cliente("A", "a@a"), 100.0f);
        float total = pedido.aplicarPagamento(new PagamentoCartaoCredito());
        assertEquals(105.0f, total);
    }

    @Test
    void deveAplicarPagamentoPix() {
        Pedido pedido = new Pedido(new Cliente("B", "b@b"), 200.0f);
        float total = pedido.aplicarPagamento(new PagamentoPix());
        assertEquals(190.0f, total);
    }

    @Test
    void deveAplicarPagamentoDinheiro() {
        Pedido pedido = new Pedido(new Cliente("C", "c@c"), 50.0f);
        float total = pedido.aplicarPagamento(new PagamentoDinheiro());
        assertEquals(50.0f, total);
    }

    @Test
    void naoDeveAplicarPagamentoComStrategyNula() {
        try {
            Pedido pedido = new Pedido(new Cliente("Z", "z@z"), 80.0f);
            pedido.aplicarPagamento(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Strategy de pagamento não informada.", e.getMessage());
        }
    }
}
