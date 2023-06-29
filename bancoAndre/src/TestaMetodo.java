public class TestaMetodo {
    public static void main(String[] args) {
        Conta contaDoAndre = new Conta(265);

        
        contaDoAndre.deposita(50);
        contaDoAndre.getSaldo();

        contaDoAndre.saca(20);
        contaDoAndre.getSaldo();

        Conta contaDaMarcela = new Conta(851);
        contaDaMarcela.deposita(1000);
        boolean transferenciaComSucesso = contaDaMarcela.transfere(300, contaDoAndre);
        if (transferenciaComSucesso) {
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Não há saldo suficiente para a transferência!");
        }

        
        
    }
}
