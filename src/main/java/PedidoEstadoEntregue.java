public class PedidoEstadoEntregue implements PedidoEstado {

    private static final PedidoEstadoEntregue instance = new PedidoEstadoEntregue();

    private PedidoEstadoEntregue() {}

    public static PedidoEstadoEntregue getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Entregue";
    }

    @Override
    public boolean avancar(Pedido pedido) {
        return false;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        return false;
    }
}
