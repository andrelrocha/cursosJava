public class ItemDeCompra {
    private int codigo;
    private String nomeProduto;
    private double preco;
    private int quantidadeComprada;

    public ItemDeCompra(int codigo, String nomeProduto, double preco, int quantidadeComprada) {
        this.codigo = codigo;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.quantidadeComprada = quantidadeComprada;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }

    public void setQuantidadeComprada(int quantidadeComprada) {
        this.quantidadeComprada = quantidadeComprada;
    }

    public double calcularTotal() {
        return preco*quantidadeComprada;
    }
}
