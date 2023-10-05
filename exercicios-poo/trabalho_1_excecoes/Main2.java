package trabalho_1_excecoes;

import java.util.Random;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var robo1=  new Robo("Azul");
        var robo2 = new Robo("Branco");

        System.out.println("Informe a coordenada x do alimento: ");
        var alimentoX = scanner.nextInt();
        System.out.println("Informe a coordenada y do alimento: ");
        var alimentoY = scanner.nextInt();
        Robo.setPosicaoAlimento(alimentoX, alimentoY);

        var random = new Random();

        int tamanhoArea = 5;
        char[][] areaLocomocao = new char[tamanhoArea][tamanhoArea];
        for (int i = 0; i < tamanhoArea; i++) {
            for (int j = 0; j < tamanhoArea; j++) {
                areaLocomocao[i][j] = ' ';
            }
        }
        areaLocomocao[alimentoY][alimentoX] = 'A';


        var movValidosRobo1 = 0;
        var movValidosRobo2 = 0;
        var movInvalidosRobo1 = 0;
        var movInvalidosRobo2 = 0;
        while (true) {
            var robo1X = robo1.getX();
            var robo1Y = robo1.getY();
            areaLocomocao[robo1Y][robo1X] = '1';

            var robo2X = robo2.getX();
            var robo2Y = robo2.getY();
            areaLocomocao[robo2Y][robo2X] = '2';

            System.out.println("Area de Locomocao:");
            for (int i = 0; i < tamanhoArea; i++) {
                for (int j = 0; j < tamanhoArea; j++) {
                    System.out.print("[" + areaLocomocao[i][j] + "]");
                }
                System.out.println();
            }


            var direcaoRobo1 = random.nextInt(4) + 1;

            try {
                robo1.mover(direcaoRobo1);
                movValidosRobo1++;
                areaLocomocao[robo1Y][robo1X] = ' ';
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
                areaLocomocao[robo2Y][robo2X] = ' ';
                if (robo2.encontrarAlimento()) {
                    System.out.println("Robo 2 encontrou o alimento!");
                    break;
                }
            } catch (MovimentoInvalidoException e) {
                movInvalidosRobo2++;
                System.out.println("Robo 2 fez um movimento inválido, perde a vez.");
                System.out.println(e.getMessage());
            }

            if (robo1.getX() > 4) {
                robo1.setX(0);
            }
            if (robo1.getY() > 4) {
                robo1.setY(0);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Número de movimentos válidos do Robo1: " + movValidosRobo1);
        System.out.println("Número de movimentos inválidos do Robo1: " + movInvalidosRobo1);
        System.out.println("Número de movimentos válidos do Robo2: " + movValidosRobo2);
        System.out.println("Número de movimentos inválidos do Robo2: " + movInvalidosRobo2);
    }
}
