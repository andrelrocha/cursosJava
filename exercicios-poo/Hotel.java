import java.util.ArrayList;

public class Hotel {
    private double valorDiaria;
    private boolean temCafe;
    private double nota;
    private ArrayList<String> quartosVagos;

    public Hotel(double valorDiaria, boolean temCafe, double nota, ArrayList<String> quartosVagos) {
        this.valorDiaria = valorDiaria;
        this.temCafe = temCafe;
        this.nota = nota;
        this.quartosVagos = quartosVagos;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public boolean isTemCafe() {
        return temCafe;
    }

    public void setTemCafe(boolean temCafe) {
        this.temCafe = temCafe;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public ArrayList<String> getQuartosVagos() {
        return quartosVagos;
    }

    public void setQuartosVagos(ArrayList<String> quartosVagos) {
        this.quartosVagos = quartosVagos;
    }

    public double calcularHospedagem(int diasOcupados) {
        return getValorDiaria()*diasOcupados;
    }

    public int ocuparQuarto(String quarto, int diasOcupados) {
        quartosVagos.remove(quarto);
        System.out.println(diasOcupados);
        return diasOcupados;
    }

    public double cobrarConsumo(double consumo, int diasOcupados) {
        var valorDiariaConsumo = calcularHospedagem(diasOcupados);
        return valorDiariaConsumo += consumo;
    }

    public double calcularTotalAPagar(double consumo, int diasOcupados) {
        var finalPrice = cobrarConsumo(consumo, diasOcupados);
        return finalPrice;
    }

    public void gerarCupomFiscal(ArrayList<String> itensConsumidos, int tipoDePagamento, double consumo, int diasOcupados) {
        for (String item : itensConsumidos) {
            System.out.println(item);
        }

        if (tipoDePagamento == 1) {
            System.out.println("O tipo de pagamento é pelo cartão");
            var valorFinal = calcularTotalAPagar(consumo, diasOcupados);
            System.out.println(valorFinal);
        } else if (tipoDePagamento == 2) {
            System.out.println("O tipo de pagamento é a vista");
            var valorFinal = 0.9*(calcularTotalAPagar(consumo, diasOcupados));
            System.out.println(valorFinal);
        } else {
            System.out.println("tipo de pagamento inválido");
        }
    }

    public void deixarAvaliacao(double notaDada) {
        if (notaDada < 0 || notaDada > 5) {
            throw new RuntimeException("nao deveria dar uma nota fora do padrão");
        }
        nota+=notaDada;
        this.nota = nota/100;
        System.out.println(nota);
    }


    public static void main(String[] args) {
        var quartosLivre = new ArrayList<String>();
        quartosLivre.add("101");
        quartosLivre.add("102");
        quartosLivre.add("103");
        quartosLivre.add("104");

        var hotel = new Hotel(150, true, 4.8, quartosLivre);

        hotel.ocuparQuarto("103", 3);
        var valor = hotel.calcularHospedagem(3);
        var itensConsumidos = new ArrayList<String>();
        itensConsumidos.add("cerveja");
        itensConsumidos.add("banana");
        itensConsumidos.add("mamao");
        var consumo = 62.50;
        var pgto = 2;


        hotel.gerarCupomFiscal(itensConsumidos, pgto, consumo, 3);

        hotel.deixarAvaliacao(4);

    }
}
