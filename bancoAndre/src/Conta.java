public class Conta {
    private double saldo;
    private int agencia = 1000;
    private int numero;
    private Titular titular;

    //metodo statico pertence a classe e não ao objeto
    private static int totalDeContas;

    //construtor da classe define os parametros necessários quando da inicialização do objeto
    public Conta(int numero) {
        totalDeContas++;
        System.out.println("Total de contas: " + totalDeContas);
        
        if(numero <= 0) {
            System.out.println("Número da conta não pode assumir valor menor ou igual a 0");
            return;
        }
        this.numero = numero;
        System.out.println("Criando uma conta");
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setAgencia(int agencia) {
        if(agencia <= 0) {
            System.out.println("Agência não pode assumir valor menor ou igual a 0");
            return;
        }
        this.agencia = agencia;
    }

    public int getAgencia() {
        return this.agencia;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public Titular getTitular() {
        return this.titular;
    }



    public void deposita(double valor) {
        if(valor < 0) {
            System.out.println("Valor a ser depositado não pode ser menor que 0");
            return;
        }
        this.saldo += valor;
    }

    public boolean saca(double valor) {
        if(valor <= 0) {
            System.out.println("Valor a ser sacado deve ser maior que 0");
            return false;
        }

        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } 
        return false;
    }

    public boolean transfere(double valor, Conta destino) {
        if(valor <= 0) {
            System.out.println("Valor a ser transferido deve ser maior que 0");
            return false;
        }
        
        if(this.saldo >= valor) {
            this.saldo -= valor;
            destino.saldo += valor;
            return true;
        }
        return false;
    }
} 