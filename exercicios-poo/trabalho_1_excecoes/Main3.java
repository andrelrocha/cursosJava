package trabalho_1_excecoes;

import java.util.Random;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        var roboNormal =  new Robo("azul");
        var roboInteligente = new RoboInteligente("Branco");

        var scanner = new Scanner(System.in);
        System.out.println("Informe a coordenada x do alimento: ");
        var alimentoX = scanner.nextInt();
        System.out.println("Informe a coordenada y do alimento: ");
        var  alimentoY = scanner.nextInt();
        Robo.setPosicaoAlimento(alimentoX, alimentoY);

        var random = new Random();

        var movRoboNormal = 0;
        var movRoboInteligente = 0;

        int tamanhoArea = 5;
        char[][] areaLocomocao = new char[tamanhoArea][tamanhoArea];
        for (int i = 0; i < tamanhoArea; i++) {
            for (int j = 0; j < tamanhoArea; j++) {
                areaLocomocao[i][j] = ' ';
            }
        }
        areaLocomocao[alimentoY][alimentoX] = 'A';

        while (!(roboNormal.encontrarAlimento() && roboInteligente.encontrarAlimento())) {
            var roboNormalX = roboNormal.getX();
            var roboNormalY = roboNormal.getY();
            areaLocomocao[roboNormalY][roboNormalX] = 'N';

            var roboInteligenteX = roboInteligente.getX();
            var roboInteligenteY = roboInteligente.getY();
            areaLocomocao[roboInteligenteY][roboInteligenteX] = 'I';

            System.out.println("Area de Locomocao:");
            for (int i = 0; i < tamanhoArea; i++) {
                for (int j = 0; j < tamanhoArea; j++) {
                    System.out.print("[" + areaLocomocao[i][j] + "]");
                }
                System.out.println();
            }

            if(!(roboNormal.encontrarAlimento())) {
                var direcaoRoboNormal = random.nextInt(4) + 1;
                try {
                    roboNormal.mover(direcaoRoboNormal);
                    movRoboNormal++;
                    areaLocomocao[roboNormalY][roboNormalX] = ' ';
                    if(roboNormal.getX() > 4) {
                        roboNormal.setX(0);
                    }
                    if(roboNormal.getY() > 4) {
                        roboNormal.setY(0);
                    }

                } catch (MovimentoInvalidoException e) {
                    System.out.println("RoboNormal: " + e.getMessage());
                }
            }

            if (!roboInteligente.encontrarAlimento()) {
                var direcaoRoboInteligente = random.nextInt(4) + 1;
                try {
                    roboInteligente.mover(direcaoRoboInteligente);
                    movRoboInteligente++;
                    areaLocomocao[roboInteligenteY][roboInteligenteX] = ' ';
                    if(roboInteligente.getX() > 4) {
                        roboInteligente.setX(0);
                    }
                    if(roboInteligente.getY() > 4) {
                        roboInteligente.setY(0);
                    }
                } catch (Exception e) {
                    System.out.println("Algo aconteceu enquanto o robo inteligente andava: " + e.getMessage());
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Robo Normal encontrou o alimento em " + movRoboNormal + " movimentos.");
        System.out.println("Robo Inteligente encontrou o alimento em " + movRoboInteligente + " movimentos.");
    }

}
