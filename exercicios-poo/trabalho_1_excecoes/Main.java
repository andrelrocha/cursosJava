package trabalho_1_excecoes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Informe a cor do robô: ");
        var corRobo = scanner.nextLine();
        var robo = new Robo(corRobo);

        System.out.print("Informe a coordenada x do alimento: ");
        var alimentoX = scanner.nextInt();
        System.out.print("Informe a coordenada y do alimento: ");
        var alimentoY = scanner.nextInt();

        Robo.setPosicaoAlimento(alimentoX, alimentoY);

        while (!robo.encontrarAlimento()) {
            System.out.print("\nInforme o movimento: ");
            String movimento = scanner.next();

            try {
                robo.mover(movimento);
            } catch (MovimentoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nO robô encontrou o alimento!");
    }
}
