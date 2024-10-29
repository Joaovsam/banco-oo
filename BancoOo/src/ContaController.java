
import java.util.Scanner;

public class ContaController {
    static Scanner sc = new Scanner(System.in);

    public void abrirMenu() {
        int option = 0;

        do {
            System.out.println("Escolha uma opção ");
            System.out.println("1 - Criar conta.");
            System.out.println("2 - Selecionar conta.");
            System.out.println("3 - listar contas.");
            System.out.println("4 - voltar");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    criarConta();
                    break;
                case 2:

                    System.out.println("Digite o número da conta");
                    int numeroConta = sc.nextInt();
                    Conta conta = App.Contas.stream().filter(x -> x.numero == numeroConta).findFirst().orElse(null);
                    if (conta == null) {
                        System.out.println("Conta inexistente");
                        break;
                    }
                    contaMenu(conta);
                    break;
                case 3:
                    System.out.println("As contas são");
                    System.out.println(App.Contas);
                    break;
                default:
                    break;
            }

        } while (option != 4);

    }

    private void criarConta() {

        System.out.println("Iniciando criação de conta");
        System.out.println("Informe seu nome");
        String nome = sc.next();
        Cliente cliente = new Cliente(nome);
        System.out.println("Seja bem vindo " + nome);
        System.out.println("Deseja criar qual tipo de conta?");
        System.out.println("1 - Conta corrente");
        System.out.println("2 - Conta poupança");
        int tipoConta = sc.nextInt();
        System.out.println("Digite uma senha numérica");
        int senha = sc.nextInt();
        final Conta novaConta;
        switch (tipoConta) {
            case 1:
                novaConta = new ContaCorrente(cliente, senha);
                break;
            case 2:
                novaConta = new ContaPoupanca(cliente, senha);
                break;
            default:
                novaConta = null;
                break;
        }
        if (novaConta != null) {
            App.Contas.add(novaConta);
            System.out.println("Conta criada!");
            return;
        }

    }

    private void contaMenu(Conta conta) {
        int optional = 0;
        do {
            System.out.println("Qual operação gostaria de fazer?");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Transferir");
            System.out.println("4 - Imprimir extrato");
            System.out.println("5 - Voltar");
            optional = sc.nextInt();
            double valor;
            int senha;
            switch (optional) {
                case 1:
                    System.out.println("Quanto gostaria de depositar?");
                    valor = sc.nextDouble();
                    conta.depositar(valor);
                    break;
                case 2:
                    System.out.println("Quanto gostaria de sacar?");
                    valor = sc.nextDouble();
                    System.out.println("digite a senha");
                    senha = sc.nextInt();
                    conta.sacar(valor, senha);
                    break;
                case 3:
                    System.out.println("Para qual conta gostaria de transferir?");
                    int numeroConta = sc.nextInt();
                    Conta contaDestino = App.Contas.stream().filter(x -> x.numero == numeroConta).findFirst()
                            .orElse(null);
                    if (contaDestino == null) {
                        System.out.println("Conta inexistente");
                        break;
                    }
                    System.out.println("Quanto gostaria de transferir?");
                    valor = sc.nextDouble();
                    System.out.println("digite a senha");
                    senha = sc.nextInt();
                    conta.transferir(valor, senha, contaDestino);
                    break;
                case 4:
                    conta.imprimirExtrato();
                    break;
            }
        } while (optional != 5);

    }

}
