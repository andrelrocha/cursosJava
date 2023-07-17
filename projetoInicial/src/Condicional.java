public class Condicional {
    public static void main(String[] args) {
        double nota1 = 8.3;
        double nota2 = 8.5;
        double nota3 = 9;

        boolean passou = false;

        double media = ( nota1 + nota2 + nota3 ) / 3;

        if (media > 7) {
            passou = true;
        }

        if (passou) {
            System.out.printf("Parabens, voce passou de ano.\nSua nota foi %.2f", media);
        } else {
            System.out.println("Infelizmente não deu certo pra ti");
        }
    }
}
