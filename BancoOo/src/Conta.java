
public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected int senha;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente, int senha) {
        this.senha = senha;
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public Conta() {

    }

    @Override
    public void sacar(double valor, int senha) {
        if (this.senha != senha) {
            System.out.println("Senha invalida");
            return;
        }
        if (saldo < valor) {
            System.out.println("Não há saldo suficiente");
            return;
        }
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, int senha, IConta contaDestino) {
        if (this.senha != senha) {
            System.out.println("Senha invalida");
            return;
        }
        if (saldo < valor) {
            System.out.println("Não ha saldo suficiente");
            return;
        }
        this.sacar(valor, senha);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    @Override
    public String toString() {
        return "{numero: " + numero + ", cliente: " + cliente.getNome() + " }";
    }

}