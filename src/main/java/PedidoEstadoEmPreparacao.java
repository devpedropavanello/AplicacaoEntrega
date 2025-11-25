public class PedidoEstadoEmPreparacao implements PedidoEstado {

    private static final PedidoEstadoEmPreparacao instance = new PedidoEstadoEmPreparacao();

    private PedidoEstadoEmPreparacao() {}

    public static PedidoEstadoEmPreparacao getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Em Preparação";
    }

    @Override
    public boolean avancar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoSaiuParaEntrega.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}
