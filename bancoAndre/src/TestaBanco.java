public class TestaBanco {
    public static void main(String[] args) {
        Titular andre = new Titular("222.222.222-22");
        andre.setNome("André");
        andre.setProfissao("Desenvolvedor");

        Endereco enderecoAndre = new Endereco();
        andre.setEndereco(enderecoAndre);

        Endereco enderecoTitular = andre.getEndereco();
            enderecoTitular.setRua("Rua do Desenvolvedor");
            enderecoTitular.setNumero(123);
            enderecoTitular.setComplemento("Casa");
            enderecoTitular.setBairro("centro");
            enderecoTitular.setCidade("Fortaleza");
            enderecoTitular.setEstado("Ceará");
            enderecoTitular.setCep("60000-000");

        Conta contaDoAndre = new Conta(123);
        contaDoAndre.deposita(100);
        contaDoAndre.setAgencia(0001);
        contaDoAndre.setTitular(andre);

        contaDoAndre.getSaldo();
        contaDoAndre.getTitular().getNome();
    }
}
