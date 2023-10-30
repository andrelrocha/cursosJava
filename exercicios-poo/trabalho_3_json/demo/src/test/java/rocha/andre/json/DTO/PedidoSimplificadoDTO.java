package rocha.andre.json.DTO;

public class PedidoSimplificadoDTO {
    private int id;
    private String dataHora;
    private String nome;
    private double valorSemDesconto;
    private double valorComDesconto;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorSemDesconto() {
        return valorSemDesconto;
    }

    public void setValorSemDesconto(double valorSemDesconto) {
        this.valorSemDesconto = valorSemDesconto;
    }

    public double getValorComDesconto() {
        return valorComDesconto;
    }

    public void setValorComDesconto(double valorComDesconto) {
        this.valorComDesconto = valorComDesconto;
    }

    @Override
    public String toString() {
        return "COMPRA DE ID " + id + "\n" +
                "Data/Hora: " + dataHora + "\n" +
                "Nome: " + nome + "\n" +
                "Valor Sem Desconto: " + valorSemDesconto + "\n" +
                "Valor Com Desconto: " + valorComDesconto;
    }
}
