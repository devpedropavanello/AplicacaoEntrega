import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String contato;
    private String ultimaNotificacao;

    public Cliente(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public String getContato() {
        return contato;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String) {
            this.ultimaNotificacao = (String) arg;
        } else {
            this.ultimaNotificacao = "Atualização no pedido.";
        }
    }
}
