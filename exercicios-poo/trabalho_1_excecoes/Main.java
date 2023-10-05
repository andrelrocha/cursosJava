package trabalho_1_excecoes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var robo = new Robo("Vermelho   ");

        System.out.print("Informe a coordenada x do alimento: ");
        var alimentoX = scanner.nextInt();
        System.out.print("Informe a coordenada y do alimento: ");
        var alimentoY = scanner.nextInt();

        Robo.setPosicaoAlimento(alimentoX, alimentoY);

        int tamanhoArea = 5;
        char[][] areaLocomocao = new char[tamanhoArea][tamanhoArea];
        for (int i = 0; i < tamanhoArea; i++) {
            for (int j = 0; j < tamanhoArea; j++) {
                areaLocomocao[i][j] = ' ';
            }
        }
        areaLocomocao[alimentoY][alimentoX] = 'A';

        while (!robo.encontrarAlimento()) {
            int roboX = robo.getX();
            int roboY = robo.getY();

            areaLocomocao[roboY][roboX] = 'R';

            System.out.println("Area de Locomocao:");
            for (int i = 0; i < tamanhoArea; i++) {
                for (int j = 0; j < tamanhoArea; j++) {
                    System.out.print("[" + areaLocomocao[i][j] + "]");
                }
                System.out.println();
            }

            System.out.print("\nInforme o movimento: ");
            var movimento = scanner.next();

            try {
                robo.mover(movimento);
                areaLocomocao[roboY][roboX] = ' ';
            } catch (MovimentoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nO robô encontrou o alimento!");
    }
}
