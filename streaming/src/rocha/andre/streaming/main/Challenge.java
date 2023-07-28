package rocha.andre.streaming.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import rocha.andre.streaming.models.Shop;

public class Challenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int esc = 1;

        List<Shop> shops = new ArrayList<>();

        System.out.println("Digite o limite do cartao: ");
        double limite = scanner.nextDouble();
        scanner.nextLine();

        while (esc != 0) {
            Shop shop = new Shop();

            System.out.println("Digite a descrição da compra: ");
            String descricao = scanner.nextLine();
            shop.setDescription(descricao);
            
            System.out.println("Digite o valor da compra: ");
            double valor = scanner.nextDouble();
            scanner.nextLine();
            shop.setValue(valor);

            if (shop.isLimitExceeded(limite)) {
                System.out.println("Limite excedido!");
                break;
            } else {
                System.out.println("Compra realizada com sucesso!");
            }

            System.out.println("Digite 0 para sair, ou qualquer outro numero para continuar.");
            esc = scanner.nextInt();
            scanner.nextLine();

            limite = shop.getLimitLeft(limite);

            shops.add(shop);
        }

        for (Shop shop : shops) {
            System.out.println("Limite do cartão: " + limite);
            System.out.println("Descrição da compra: " + shop.getDescription());
            System.out.println("Valor da compra: " + shop.getValue());
            System.out.println("---------------");
        }

        scanner.close();

        shops.sort(Comparator.comparing(Shop::getValue));

        for (Shop shop : shops) {
            System.out.println("Descrição da compra: " + shop.getDescription());
            System.out.println("Valor da compra: " + shop.getValue());
            System.out.println("---------------");
        }
    }
}
