public interface PedidoEstado {
    String getEstado();

    boolean avancar(Pedido pedido);


    boolean cancelar(Pedido pedido);
}
