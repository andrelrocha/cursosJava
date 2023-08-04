public class TestaFor {

	public static void main(String[] args) {
		System.out.println("estou contando: ");
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		for (int multiplicador = 2; multiplicador <= 10; multiplicador++) {
			System.out.println("Tabuada do " + multiplicador);
			for (int contador = 1; contador <= 10; contador++) {
				System.out.print(multiplicador + "x" + contador + "=" + (multiplicador * contador));
				System.out.print(" ");
			}
			System.out.println("\n");
		}
		for (int linha=0;linha<10;linha++) {
			for (int coluna=0;coluna<=linha;coluna++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}