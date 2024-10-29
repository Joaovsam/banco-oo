
public interface IConta {

    void sacar(double valor, int senha);

    void depositar(double valor);

    void transferir(double valor, int senha, IConta contaDestino);

    void imprimirExtrato();
}