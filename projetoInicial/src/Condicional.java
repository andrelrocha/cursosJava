import java.util.Scanner;

public class Condicional {
    public static void main(String[] args) {
        double nota1 = 8.3;
        double nota2 = 8.5;
        double nota3 = 9;

        boolean passou = false;

        double media = ( nota1 + nota2 + nota3 ) / 3;

        if (media > 7) {
            passou = true;
        }

        if (passou) {
            System.out.printf("Parabens, voce passou de ano.\nSua nota foi %.2f\n", media);
        } else {
            System.out.println("Infelizmente não deu certo pra ti\n");
        }

        ////////////////////////

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
