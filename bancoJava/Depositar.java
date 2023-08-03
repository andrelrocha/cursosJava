import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Depositar {
    public static void main() {
        List<Conta> listaDeContas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do titular:");
        String nomeTitularDeposito = scanner.next();
        System.out.println("Digite o valor a ser depositado:");
        double valorDeposito = scanner.nextDouble();

        for (Conta conta : listaDeContas) {
            if (conta.getNome().equals(nomeTitularDeposito)) {
                conta.depositar(valorDeposito);
                System.out.println("Depósito realizado com sucesso!");
                return;
            }
        }

        System.out.println("Conta não encontrada para o titular informado.");
    }
}
