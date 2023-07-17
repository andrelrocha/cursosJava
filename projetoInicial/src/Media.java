import java.util.Scanner;

public class Media {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] notas = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.printf("Digite a nota %d: ", i + 1);
            notas[i] = scanner.nextDouble();
        }

        boolean passou = false;

        double soma = 0;
        for (int i = 0; i < 3; i++) {
            soma += notas[i];
        }

        double media = ( soma ) / 3;

        if (media > 7) {
            passou = true;
        }

        if (passou) {
            System.out.printf("Parabens, voce passou de ano.\nSua nota foi %.2f\n", media);
        } else {
            System.out.println("Infelizmente não deu certo pra ti\n");
        }
    }
}
