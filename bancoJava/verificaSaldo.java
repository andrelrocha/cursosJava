import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class verificaSaldo {
    public static void main() {
        List<Conta> listaDeContas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome do titular:");
        String nomeTitularSaldo = scanner.next();

        for (Conta conta : listaDeContas) {
            if (conta.getNome().equals(nomeTitularSaldo)) {
                System.out.println("O saldo da conta é de R$ " + conta.getSaldo());
                return;
            }
        }

        System.out.println("Conta não encontrada para o titular informado.");

    }
}
