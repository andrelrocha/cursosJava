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

        System.out.println("Digite o número da operação que deseja realizar:");
        int escolha = 0;
        escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                CriaConta.main();
                break;
            case 2: 
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
                break;
            case 3: 
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
                break;
            case 4: 
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
                break;
            case 5:
                System.out.println("Digite o nome do titular:");
                String nomeTitularSaldo = scanner.next();

                for (Conta conta : listaDeContas) {
                    if (conta.getNome().equals(nomeTitularSaldo)) {
                        System.out.println("O saldo da conta é de R$ " + conta.getSaldo());
                        return;
                    }
                }

                System.out.println("Conta não encontrada para o titular informado.");
                break;
        }
    }
}
