package trabalho_1_excecoes;

import java.util.ArrayList;
import java.util.Random;

public class RoboInteligente extends Robo {

    public RoboInteligente(String cor) {
        super(cor);
    }

    @Override
    public void mover(int direcao) {
        var rand = new Random();

        while (true) {
            try {
                super.mover(direcao);
                break;
            } catch (MovimentoInvalidoException e) {
                direcao = rand.nextInt(4) + 1;
            }
        }
    }

    @Override
    public void mover(String direcao) {
        var rand = new Random();
        var direcoes = new ArrayList<String>();
        direcoes.add("up");
        direcoes.add("down");
        direcoes.add("left");
        direcoes.add("right");

        while (true) {
            try {
                super.mover(direcao);
                break;
            } catch (MovimentoInvalidoException e) {
                direcao = direcoes.get(rand.nextInt(4));
            }
        }
    }
}
