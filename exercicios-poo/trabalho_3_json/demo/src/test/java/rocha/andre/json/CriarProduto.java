package rocha.andre.json;

import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@Component
public class CriarProduto {
    public void criarProduto() {
        try {
            var produto = new Produto();
            solicitarInformacoesAoUsuario(produto);

            var json = produto.toJson();

            var file = new File("json/produto.json");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(json);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao escrever o arquivo JSON");
            }

            System.out.println("JSON: " + json);
            System.out.println("Produto salvo em 'produto.json'");
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException("Algo aconteceu");
        }
    }

    private void solicitarInformacoesAoUsuario(Produto produto) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do produto:");
        produto.setNome(scanner.nextLine());

        System.out.println("Digite a descrição do produto:");
        produto.setDescricao(scanner.nextLine());

        System.out.println("Digite o preço do produto:");
        produto.setPreco(scanner.nextDouble());

        System.out.println("Digite a quantidade do produto:");
        produto.setQuantidade(scanner.nextInt());
    }
}
