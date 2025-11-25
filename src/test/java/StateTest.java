import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StateTest {

    @Test
    void deveAlterarEstadoParaCriado() {
        Pedido pedido = new Pedido(new Cliente("A", "a@a"), 50.0f);
        pedido.setEstado(PedidoEstadoCriado.getInstance());
        assertEquals("Criado", pedido.getNomeEstado());
    }

    @Test
    void deveAlterarEstadoParaEmPreparacao() {
        Pedido pedido = new Pedido(new Cliente("B", "b@b"), 80.0f);
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        assertEquals("Em Preparação", pedido.getNomeEstado());
    }

    @Test
    void deveAlterarEstadoParaSaiuParaEntrega() {
        Pedido pedido = new Pedido(new Cliente("C", "c@c"), 90.0f);
        pedido.setEstado(PedidoEstadoSaiuParaEntrega.getInstance());
        assertEquals("Saiu para Entrega", pedido.getNomeEstado());
    }

    @Test
    void deveAlterarEstadoParaEntregue() {
        Pedido pedido = new Pedido(new Cliente("D", "d@d"), 120.0f);
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertEquals("Entregue", pedido.getNomeEstado());
    }

    @Test
    void naoDeveAvancarEstadoDepoisDeEntregue() {
        Pedido pedido = new Pedido(new Cliente("E", "e@e"), 40.0f);
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        boolean avancou = pedido.avancarEstado();
        assertFalse(avancou);
        assertEquals("Entregue", pedido.getNomeEstado());
    }

    @Test
    void deveCancelarEmQualquerEstadoExcetoEntregue() {
        Pedido pedido = new Pedido(new Cliente("F", "f@f"), 60.0f);
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        boolean cancelou = pedido.cancelar();
        assertTrue(cancelou);
        assertEquals("Cancelado", pedido.getNomeEstado());
    }

    @Test
    void naoDeveCancelarDepoisDeEntregue() {
        Pedido pedido = new Pedido(new Cliente("G", "g@g"), 70.0f);
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        boolean cancelou = pedido.cancelar();
        assertFalse(cancelou);
        assertEquals("Entregue", pedido.getNomeEstado());
    }
}


