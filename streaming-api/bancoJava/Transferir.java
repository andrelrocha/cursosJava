import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Transferir {
    public static void main() {
        List<Conta> listaDeContas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome do titular da conta de origem:");
        String nomeTitularOrigem = scanner.next();
        System.out.println("Digite o nome do titular da conta de destino:");
        String nomeTitularDestino = scanner.next();
        System.out.println("Digite o valor a ser transferido:");
        double valorTransferencia = scanner.nextDouble();

        Conta contaOrigem = null;
        Conta contaDestino = null;

        for (Conta conta : listaDeContas) {
            if (conta.getNome().equals(nomeTitularOrigem)) {
                contaOrigem = conta;
            }

            if (conta.getNome().equals(nomeTitularDestino)) {
                contaDestino = conta;
            }
        }

        if (contaOrigem == null || contaDestino == null) {
            System.out.println("Conta de origem ou destino não encontrada.");
            return;
        }

        contaOrigem.transferir(valorTransferencia, contaDestino);
        System.out.println("Transferência realizada com sucesso!");        
    }
}
