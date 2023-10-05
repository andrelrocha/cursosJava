package trabalho_1_excecoes;

public class MovimentoInvalidoException extends Exception {
    public MovimentoInvalidoException(int x, int y) {
        super("Movimento inválido para coordenadas negativas: x = " + x + ", y = " + y);
    }
}
