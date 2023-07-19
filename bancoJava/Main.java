import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Conta> listaDeContas = new ArrayList<>();

        System.out.println("Bem vindo ao seu banco digital em Java");

        System.out.println("Em nosso banco você pode realizar diversas operações, como:");
        System.out.println("1 - Abrir uma conta");
        System.out.println("2 - Depositar");
        System.out.println("3 - Sacar");
        System.out.println("4 - Transferir");
        System.out.println("5 - Verificar saldo");
        System.out.println("0 - Sair");

        System.out.println("Digite o número da operação que deseja realizar:");
        int escolha = 0;
        escolha = scanner.nextInt();

        while (escolha != 0) {
            
            switch (escolha) {
            case 1:
                CriaConta.main();
                break;
            case 2: 
                Depositar.main();
                break;
            case 3: 
                Sacar.main();
                break;
            case 4: 
                Transferir.main();
                break;
            case 5:
                verificaSaldo.main();
                break;
        }
            
            
            if (escolha > 5 || escolha < 0) {
                System.out.println("Operação inválida.");
                System.out.println("Digite o número da operação que deseja realizar:");
                escolha = scanner.nextInt();
            } else {
                break;
            }
        }
    }
}
