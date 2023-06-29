public class TestaCondicional {

	public static void main(String[] args) {
		System.out.println("testando condicionais");
		int idade = 23;
		String nome = "Andre";
		String bebida = "";
		if (idade > 18) {
			bebida = "cerveja";
		} else {
			bebida = "suco";
		}
		System.out.println("Olá, " + nome + ". Aqui está seu copo de " + bebida);

		int qtdPessoas = 3;
		boolean acompanhado = true;
		// boolean acompanhado=qtdPessoas>=2;
		if (idade > 20 && qtdPessoas >= 3 && acompanhado) {
			System.out.println("Você é bem vindo.");
		} else if (qtdPessoas > 10) {
			System.out.println("Aqui seu crachá VIP.");
		}
	}
}
