
public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente, int senha) {
        super(cliente, senha);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }

}