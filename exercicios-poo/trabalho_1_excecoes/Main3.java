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


        while (!(roboNormal.encontrarAlimento() && roboInteligente.encontrarAlimento())) {
            if(!(roboNormal.encontrarAlimento())) {
                var direcaoRoboNormal = random.nextInt(4) + 1;
                try {
                    roboNormal.mover(direcaoRoboNormal);
                    movRoboNormal++;
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

        }

        System.out.println("Robo Normal encontrou o alimento em " + movRoboNormal + " movimentos.");
        System.out.println("Robo Inteligente encontrou o alimento em " + movRoboInteligente + " movimentos.");
    }

}
