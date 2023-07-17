import java.util.Scanner;

public class Condicional {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String nomeManga = "Berserk";
        String nomeMangaDois = "Vagabond";

        System.out.println("Qual o melhor manga da historia?");
        String escolha = scanner.nextLine();
        String escolhaFormatada = escolha.substring(0,1).toUpperCase() + escolha.substring(1);

        if (escolhaFormatada.equals(nomeManga) || escolhaFormatada.equals(nomeMangaDois)) {
            System.out.println("Acertou!");
        } else {
            System.out.printf("Como assim %s. Você deveria ler Berserk", escolhaFormatada);
        }

    }
}
