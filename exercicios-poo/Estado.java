import java.util.ArrayList;

public class Estado {
    private String nome;
    private String sigla;
    private double precoGasolina;
    private double precoAlcool;

    private static ArrayList<Estado> listaEstado;

    public Estado(String nome, String sigla, double precoAlcool, double precoGasolina) {
        this.nome = nome;
        this.sigla = sigla;
        this.precoAlcool = precoAlcool;
        this.precoGasolina = precoGasolina;
        listaEstado = new ArrayList<Estado>();
    }

    public String getNome() {
        return nome;
    }
    public String getSigla() {
        return sigla;
    }
    public double getPrecoGasolina() {
        return precoGasolina;
    }
    public double getPrecoAlcool() {
        return precoAlcool;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public void setPrecoGasolina(double precoGasolina) {
        this.precoGasolina = precoGasolina;
    }
    public void setPrecoAlcool(double precoAlcool) {
        this.precoAlcool = precoAlcool;
    }

    public String vantagem() {
        boolean vantagem = false;
        if (precoAlcool <= (0.7*precoGasolina)) {
            vantagem =true;
        }

        if(vantagem) {
            System.out.printf("%s ALCOOL", sigla);
            return "alcool";
        } else {
            System.out.printf("%s GASOLINA", sigla);
            return "gasolina";
        }
    }

    public static void lista(Estado estado) {
        listaEstado.add(estado);

        for(int i = 0; i < listaEstado.size(); i++) {
            for (int j = 0; j < (listaEstado.size() - 1); j++) {
                var precoAtual = listaEstado.get(j).getPrecoAlcool();
                var precoSeguinte = listaEstado.get(j+1).getPrecoAlcool();

                if (precoAtual > precoSeguinte) {
                    var temp = listaEstado.get(j);
                    listaEstado.set(j, listaEstado.get(j+1));
                    listaEstado.set(j+1, temp);
                }
            }
        }
    }

    public static void imprimir() {
        System.out.println(listaEstado);
        for (Estado e : listaEstado) {
            System.out.println("Nome: " + e.getNome() + ", Preço Gasolina: " + e.getPrecoGasolina() + ", Preço Álcool: " + e.getPrecoAlcool());
        }
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Sigla: " + sigla + ", Preço Gasolina: " + precoGasolina + ", Preço Álcool: " + precoAlcool;
    }

    public static void main(String[] args) {
        var newState = new Estado("Ceara", "CE", 3.00, 5.30);
        var newNewState = new Estado("SaoPaulo", "SP", 2.50, 5.20);

        Estado.lista(newState);
        Estado.lista(newNewState);

        Estado.imprimir();
    }
}
