import java.util.Random;
import java.util.Scanner;

public class CriaConta {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        Titular novoTitular = new Titular();
            System.out.println("Digite seu nome:");
            String nome = scanner.next();
            novoTitular.setNome(nome);
            System.out.println("Digite seu CPF:");
            String cpf = scanner.next();
            novoTitular.setCpf(cpf);
            System.out.println("Digite sua idade:");
            int idade = scanner.nextInt();
            novoTitular.setIdade(idade);

            System.out.println("Digite o nome da sua rua:");
            String rua = scanner.next();
            System.out.println("Digite o número da sua casa:");
            int numero = scanner.nextInt();
            Endereco novoEndereco = new Endereco(rua, numero);

            System.out.println("Digite o complemento do seu endereço:");
            String complemento = scanner.next();
            novoEndereco.setComplemento(complemento);

            novoTitular.setEndereco(novoEndereco);

            int numeroConta = random.nextInt(10000);
            new Conta(numeroConta, novoTitular);
    }
}
