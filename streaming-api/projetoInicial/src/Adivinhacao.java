import java.util.Random;
import java.util.Scanner;

public class Adivinhacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int newNumber = new Random().nextInt(100);
        int tries = 0;

        while (tries < 5) {
            System.out.println("What is the secret number?\n");
            int choice = scanner.nextInt();

            if (choice == newNumber) {
                System.out.println("Congrats! You found the secret number");
                break;
            } else if (choice < newNumber) {
                System.out.println("Your number was lesser than the secret number");
            } else {
                System.out.println("Your number was greater than the secret number");
            }

            tries++;
        }

        if (tries == 5) {
            System.out.println("You ran out of attempts");
        }
    }

}
