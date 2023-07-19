import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sacar {
    public static void main() {
        List<Conta> listaDeContas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome do titular:");
        String nomeTitularSaque = scanner.next();
        System.out.println("Digite o valor a ser sacado:");
        double valorSaque = scanner.nextDouble();

        for (Conta conta : listaDeContas) {
            if (conta.getNome().equals(nomeTitularSaque)) {
                conta.sacar(valorSaque);
                System.out.println("Saque realizado com sucesso!");
                return;
            }
        }

        System.out.println("Conta não encontrada para o titular informado.");
    }
}
