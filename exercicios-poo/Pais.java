
public class Pais {
    private String nome;
    private String nomeCapital;
    private double dimensao;
    private Pais[] paisesFronteira;

    public Pais (String nome, String nomeCapital, float dimensao) {
        this.nome = nome;
        this.nomeCapital = nomeCapital;
        this.dimensao = dimensao;
    }

    public String getNome() {
        return nome;
    }
    public String getNomeCapital() {
        return  nomeCapital;
    }
    public double getDimensao() {
        return dimensao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNomeCapital(String nomeCapital) {
        this.nomeCapital = nomeCapital;
    }
    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }


    public boolean equals (Pais outro) {
        if (nome.equals(outro.nome) && nomeCapital.equals(outro.nomeCapital)) {
            return true;
        }

        return false;
    }

    public String fronteira(Pais[] outro) {
        paisesFronteira = new Pais[outro.length];

        int tamanho = 0;

        for(Pais p : outro) {
            if (equals(p)) {
                System.out.println("nao pode fazer fronteira com ele mesmo");
            } else {
                paisesFronteira[tamanho] = p;
                tamanho++;
            }
        }

        this.paisesFronteira = paisesFronteira;
        return "paises adicionados";
    }

    public void retornoNomes() {
        for (Pais p : paisesFronteira) {
            System.out.println(p.nome);
            System.out.println(p.nomeCapital);
        }
    }

    public static void main(String[] args) {
        var pais = new Pais("Brasil", "brasilia", 10000);

        var pais1 = new Pais("Japao", "tokyo", 1000);
        var pais2 = new Pais("alemanha", "berlim", 500);
        Pais[] paisesFronteira = new Pais[2];
        paisesFronteira[0] = pais1;
        paisesFronteira[1] = pais2;


        pais.fronteira(paisesFronteira);

        pais.retornoNomes();
    }
}
