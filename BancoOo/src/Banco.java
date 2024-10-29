import java.util.ArrayList;
import java.util.List;

public class Banco {
    private static int SEQUENCIAL = 1;

    private int id;
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.id = Banco.SEQUENCIAL++;
        this.nome = nome;
        this.contas = new ArrayList<Conta>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void addConta(Conta conta) {
        this.contas.add(conta);
    }

    public int getId() {
        return this.id;
    }

}