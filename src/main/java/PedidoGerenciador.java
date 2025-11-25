import java.util.ArrayList;
import java.util.List;

public class PedidoGerenciador {

    private static PedidoGerenciador instancia = new PedidoGerenciador();

    private List<Pedido> pedidos = new ArrayList<>();

    private PedidoGerenciador() {}

    public static PedidoGerenciador getInstancia() {
        return instancia;
    }

    public void registrarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void limpar() {
        pedidos.clear();
    }
}
