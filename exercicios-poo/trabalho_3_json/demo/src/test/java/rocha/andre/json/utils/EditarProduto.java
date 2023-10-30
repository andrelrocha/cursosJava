package rocha.andre.json.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;
import rocha.andre.json.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class EditarProduto {
    public void editarProduto() {
        try {
            // Lê o arquivo JSON existente
            File file = new File("json/produto.json");
            List<Produto> produtos = lerProdutos(file);

            if (produtos.isEmpty()) {
                System.out.println("Nenhum produto encontrado para edição.");
                return;
            }

            // Solicita o nome do produto que o usuário deseja editar
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o nome do produto que deseja editar: ");
            String nomeProduto = scanner.nextLine();

            // Encontra o produto pelo nome
            Produto produtoParaEditar = null;
            for (Produto produto : produtos) {
                if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                    produtoParaEditar = produto;
                    break;
                }
            }

            if (produtoParaEditar == null) {
                System.out.println("Produto não encontrado.");
                return;
            }

            System.out.println("Digite a nova descrição: ");
            String novaDescricao = scanner.nextLine();
            System.out.println("Digite o novo preço: ");
            double novoPreco = scanner.nextDouble();
            System.out.println("Digite a nova quantidade: ");
            int novaQuantidade = scanner.nextInt();

            produtoParaEditar.setDescricao(novaDescricao);
            produtoParaEditar.setPreco(novoPreco);
            produtoParaEditar.setQuantidade(novaQuantidade);

            escreverProdutos(file, produtos);

            System.out.println("Produto editado com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Algo aconteceu");
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

    private void escreverProdutos(File file, List<Produto> produtos) throws IOException {
        Gson gson = new Gson();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(gson.toJson(produtos));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao escrever o arquivo JSON");
        }
    }
}
