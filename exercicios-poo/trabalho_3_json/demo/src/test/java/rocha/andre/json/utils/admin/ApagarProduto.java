package rocha.andre.json.utils.admin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;
import rocha.andre.json.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ApagarProduto {
    public void apagarProduto() throws IOException {
        File file = new File("json/produto.json");
        List<Produto> produtos = lerProdutos(file);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do produto que deseja apagar: ");
        String nomeProduto = scanner.nextLine();

        Produto produtoParaApagar = null;
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                produtoParaApagar = produto;
                break;
            }
        }

        if (produtoParaApagar != null) {
            produtos.remove(produtoParaApagar);
            salvarProdutos(file, produtos);
            System.out.println("Produto apagado com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private List<Produto> lerProdutos(File file) throws IOException {
        Gson gson = new Gson();
        List<Produto> produtos = new ArrayList<>();
        if (file.exists()) {
            try (Reader reader = new FileReader(file)) {
                produtos = gson.fromJson(reader, new TypeToken<List<Produto>>() {}.getType());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao ler o arquivo JSON");
            }
        }
        return produtos;
    }

    private void salvarProdutos(File file, List<Produto> produtos) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Writer writer = new FileWriter(file)) {
            writer.write(gson.toJson(produtos));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao escrever o arquivo JSON");
        }
    }
}
