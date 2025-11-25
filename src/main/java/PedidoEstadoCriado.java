public class PedidoEstadoCriado implements PedidoEstado {

    private static final PedidoEstadoCriado instance = new PedidoEstadoCriado();

    private PedidoEstadoCriado() {}

    public static PedidoEstadoCriado getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Criado";
    }

    @Override
    public boolean avancar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}
