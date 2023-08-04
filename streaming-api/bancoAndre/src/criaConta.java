public class criaConta {
	public static void main(String[] args) {
		Conta primeiraConta = new Conta(1234);
		primeiraConta.deposita(200);
		
		Conta segundaConta = new Conta(4321);
		segundaConta.deposita(50);

		System.out.println("a primeira conta tem R$ " + primeiraConta.getSaldo());
		System.out.println("a segunda conta tem R$ " + segundaConta.getSaldo());
	}
}