package rocha.andre.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Scanner;
import com.google.gson.Gson;

@Component
public class CriarProduto {
    public void criarProduto() {
        try {
            var produto = new Produto();
            solicitarInformacoesAoUsuario(produto);

            Gson gson = new Gson();
            JsonArray jsonArray;

            var file = new File("json/produto.json");

            try {
                Reader reader = new FileReader(file);
                jsonArray = gson.fromJson(reader, JsonArray.class);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao ler o arquivo JSON");
            }


            var jsonNovoProduto = produto.toJson();
            jsonArray.add(gson.fromJson(jsonNovoProduto, JsonObject.class));

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(gson.toJson(jsonArray));
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao escrever o arquivo JSON");
            }

            System.out.println("JSON: " + jsonNovoProduto);
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
