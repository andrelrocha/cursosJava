public class Filme {
    private String nome;
    private String diretor;
    private int codigo;
    private int ano;

    private static int cont = 0;

    public Filme(String nome) {
        cont++;

        this.nome = nome;

        System.out.println("Criando um filme");
    }

    public static int getCont() {
        return cont;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
