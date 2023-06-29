public class Titular {
    private String nome;
    private String cpf;
    private String profissao;
    private Endereco endereco;

    public Titular(String cpf) {
        this.cpf = cpf;
        System.out.println("Criando um titular");
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return this.nome;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }
}
