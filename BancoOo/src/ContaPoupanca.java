
public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente, int senha) {
        super(cliente, senha);
    }

    public ContaPoupanca() {

    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }
}