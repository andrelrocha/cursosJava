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
        var cont = 0;


        while (!(roboNormal.encontrarAlimento() && roboInteligente.encontrarAlimento())) {
            if(!(roboNormal.encontrarAlimento())) {
                var direcaoRoboNormal = random.nextInt(4) + 1;
                try {
                    roboNormal.mover(direcaoRoboNormal);
                    movRoboNormal++;
                } catch (MovimentoInvalidoException e) {
                    System.out.println("RoboNormal: " + e.getMessage());
                }
            }

            if (roboInteligente.encontrarAlimento()) {
                var direcaoRoboInteligente = random.nextInt(4) + 1;
                try {
                    roboInteligente.mover(direcaoRoboInteligente);
                    movRoboInteligente++;
                } catch (Exception e) {
                    System.out.println("Algo aconteceu enquanto o robo inteligente andava: " + e.getMessage());
                }
            }

            cont ++;
            if (cont % 50 == 0) {
                System.out.print("Digite 0 para parar, digite qualquer outra coisa para continuar: ");
                var choice = scanner.nextInt();

                if (choice == 0) {
                    System.out.println("ENCERRANDO O LOOP!");
                    break;
                }
            }
        }

        System.out.println("Robo Normal encontrou o alimento em " + movRoboNormal + " movimentos.");
        System.out.println("Robo Inteligente encontrou o alimento em " + movRoboInteligente + " movimentos.");
    }

}
