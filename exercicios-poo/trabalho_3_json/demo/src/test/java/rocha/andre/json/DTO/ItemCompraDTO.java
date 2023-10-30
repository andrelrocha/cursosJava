package rocha.andre.json.DTO;

public class ItemCompraDTO {
    private String nome;
    private double preco;
    private int quantidadeDesejada;

    public ItemCompraDTO(String nome, double preco, int quantidadeDesejada) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeDesejada = quantidadeDesejada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeDesejada() {
        return quantidadeDesejada;
    }

    public void setQuantidadeDesejada(int quantidadeDesejada) {
        this.quantidadeDesejada = quantidadeDesejada;
    }

}