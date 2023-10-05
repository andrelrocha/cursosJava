package trabalho_1_excecoes;

import java.util.Random;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe a cor do robô 1: ");
        var corRobo1 = scanner.nextLine();
        var robo1 = new Robo(corRobo1);
        System.out.print("Informe a cor do robô 2: ");
        var corRobo2 = scanner.nextLine();
        var robo2 = new Robo(corRobo2);

        System.out.print("Informe a coordenada x do alimento: ");
        var alimentoX = scanner.nextInt();
        System.out.print("Informe a coordenada y do alimento: ");
        var alimentoY = scanner.nextInt();
        Robo.setPosicaoAlimento(alimentoX, alimentoY);

        var random = new Random();


        var cont = 0;
        var movValidosRobo1 = 0;
        var movValidosRobo2 = 0;
        var movInvalidosRobo1 = 0;
        var movInvalidosRobo2 = 0;
        while (true) {
            var direcaoRobo1 = random.nextInt(4) + 1;

            try {
                robo1.mover(direcaoRobo1);
                movValidosRobo1++;
                if (robo1.encontrarAlimento()) {
                    System.out.println("Robo 1 encontrou o alimento!");
                    break;
                }
            } catch (MovimentoInvalidoException e) {
                movInvalidosRobo1++;
                System.out.println("Robo 1 fez um movimento inválido, perde a vez.");
                System.out.println(e.getMessage());
            }

            var direcaoRobo2 = random.nextInt(4) + 1;

            try {
                robo2.mover(direcaoRobo2);
                movValidosRobo2++;
                if (robo2.encontrarAlimento()) {
                    System.out.println("Robo 2 encontrou o alimento!");
                    break;
                }
            } catch (MovimentoInvalidoException e) {
                movInvalidosRobo2++;
                System.out.println("Robo 2 fez um movimento inválido, perde a vez.");
                System.out.println(e.getMessage());
            }

            cont ++;
            if (cont % 10 == 0) {
                System.out.print("Digite 0 para parar, digite qualquer outra coisa para continuar: ");
                var choice = scanner.nextInt();

                if (choice == 0) {
                    System.out.println("ENCERRANDO O LOOP!");
                    break;
                }
            }
        }
        System.out.println("Número de movimentos válidos do Robo1: " + movValidosRobo1);
        System.out.println("Número de movimentos inválidos do Robo1: " + movInvalidosRobo1);
        System.out.println("Número de movimentos válidos do Robo2: " + movValidosRobo2);
        System.out.println("Número de movimentos inválidos do Robo2: " + movInvalidosRobo2);
    }
}
