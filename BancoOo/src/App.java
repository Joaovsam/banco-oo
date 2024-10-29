import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    static List<Conta> Contas = new ArrayList<>();
    static ContaController contaController = new ContaController();

    public static void main(String[] args) throws Exception {

        int option = 0;

        do {
            System.out.println("O que deseja abrir?");
            System.out.println("1 - Menu de contas.");
            System.out.println("2 - sair");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    contaController.abrirMenu();
                    break;
                case 2:
                    System.out.println("Desligando...");
                    break;
            }

        } while (option != 2);

        sc.close();

    }

}
