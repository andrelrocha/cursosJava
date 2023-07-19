public class Endereco {
    private String rua;
    private String complemento;
    private int numero;

    public Endereco(String rua, int numero) {
        this.rua = rua;
        this.numero = numero;
    }


    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
