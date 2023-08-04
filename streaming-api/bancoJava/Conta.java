public class Conta {
    private double saldo;
    private int agencia = 0001;
    private int conta;
    private Titular titular;

    public Conta(int conta, Titular titular) {
        this.conta = conta;
        this.titular = titular;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNome() {
        return titular.getNome();
    }

    public void depositar(double valor) {
        if (valor < 0) {
            System.out.println("O depósito deve ser feito com valores positivos.");
            return;
        }

        saldo += valor;
        System.out.printf("O novo valor total da conta é de R$ %f", saldo);
    }

    public void sacar(double valor) {
        if(valor <= 0) {
            System.out.println("Valor a ser sacado deve ser maior que 0");
            return;
        }
        
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
            return;
        }

        saldo -= valor;
        System.out.printf("O novo valor total da conta é de R$ %f", saldo);
    }

    public void transferir(double valor, Conta conta) {
        if(valor <=0) {
            System.out.println("Valor a ser transferido deve ser maior que 0");
            return;
        }
        
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
            return;
        }

        saldo -= valor;
        conta.depositar(valor);
        System.out.printf("O novo valor total da conta é de R$ %f", saldo);
    }

    public void imprimir() {
        System.out.println("Agência: " + agencia);
        System.out.println("Conta: " + conta);
        System.out.println("Titular: " + titular.getNome());
        System.out.println("Saldo: " + saldo);
    }
}
