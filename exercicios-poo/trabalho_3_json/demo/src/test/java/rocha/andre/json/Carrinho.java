package rocha.andre.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import rocha.andre.json.DTO.CarrinhoDTO;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Carrinho {
    public void executar() {
        ArrayList<Produto> produtos = carregarProdutosDoJSON();

        System.out.println("Produtos Disponíveis:");
        for (Produto produto : produtos) {
            System.out.println(produto.getNome());
        }

        var scanner = new Scanner(System.in);
        ArrayList<CarrinhoDTO> carrinho = new ArrayList<>();

        while (true) {
            System.out.print("Digite o nome do produto desejado (ou 'sair' para encerrar): ");
            String nomeProduto = scanner.nextLine();

            if (nomeProduto.equalsIgnoreCase("sair")) {
                break;
            }

            Produto produtoSelecionado = null;
            for (Produto produto : produtos) {
                if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                    produtoSelecionado = produto;
                    break;
                }
            }

            if (produtoSelecionado == null) {
                System.out.println("Produto não encontrado. Tente novamente.");
                continue;
            }

            System.out.print("Digite a quantidade desejada: ");
            int quantidadeDesejada = scanner.nextInt();

            scanner.nextLine();

            if (quantidadeDesejada > produtoSelecionado.getQuantidade()) {
                System.out.println("Quantidade desejada maior do que a disponível. Tente novamente.");
                continue;
            }

            carrinho.add(new CarrinhoDTO(produtoSelecionado.getNome(), quantidadeDesejada));

            System.out.println("Produto adicionado ao carrinho.");
        }

        salvarCarrinhoNoJSON(carrinho);
    }

    private ArrayList<Produto> carregarProdutosDoJSON() {
        Gson gson = new Gson();
        JsonArray jsonArray;

        var file = new File("json/produto.json");

        try {
            var reader = new FileReader(file);
            jsonArray = gson.fromJson(reader, JsonArray.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao ler o arquivo JSON");
        }

        ArrayList<Produto> produtos = new ArrayList<>();
        for (JsonElement element : jsonArray) {
            var produto = gson.fromJson(element, Produto.class);
            produtos.add(produto);
        }

        return produtos;
    }

    private void salvarCarrinhoNoJSON(ArrayList<CarrinhoDTO> carrinho) {
        var objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("json/carrinho.json"), carrinho);
            System.out.println("Carrinho salvo com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
