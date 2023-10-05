package trabalho_1_excecoes;

public class Robo {
    private int x;
    private int y;
    private String cor;

    public Robo(String cor) {
        this.cor = cor;
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void mover(String direcao) throws MovimentoInvalidoException {
        var movX = 0;
        var movY = 0;

        if (direcao.equals("up")) {
            movY = 1;
        } else if (direcao.equals("down")) {
            movY = -1;
        } else if (direcao.equals("right")) {
            movX = 1;
        } else if (direcao.equals("left")) {
            movX = -1;
        }

        var newX = x + movX;
        var newY = y + movY;

        if (newX >= 0 && newY >= 0) {
            x += movX;
            y += movY;
            System.out.printf("Nova posição robo cor %s: (%d, %d)\n", this.cor, x, y);
        } else {
            throw new MovimentoInvalidoException(newX, newY);
        }
    }

    public void mover(int direcao) throws MovimentoInvalidoException {
        int movX = 0;
        int movY = 0;

        switch (direcao) {
            case 1:
                movY = 1;
                break;
            case 2:
                movY = -1;
                break;
            case 3:
                movX = 1;
                break;
            case 4:
                movX = -1;
                break;
        }

        var newX = x + movX;
        var newY = y + movY;

        if (newX >= 0 && newY >= 0) {
            x += movX;
            y += movY;
            System.out.printf("Nova posição robo cor %s: (%d, %d)\n", this.cor, x, y);
        } else {
            throw new MovimentoInvalidoException(newX, newY);
        }
    }



    private static int alimentoX;
    private static int alimentoY;
    public static void setPosicaoAlimento(int x, int y) {
        alimentoX = x;
        alimentoY = y;
    }

    public boolean encontrarAlimento() {
        return x == alimentoX && y == alimentoY;
    }
}
