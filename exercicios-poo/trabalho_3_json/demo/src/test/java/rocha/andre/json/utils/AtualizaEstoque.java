package rocha.andre.json.utils;

import com.google.gson.*;
import org.springframework.stereotype.Component;
import rocha.andre.json.DTO.ItemCompraDTO;

import java.io.*;
import java.util.ArrayList;

@Component
public class AtualizaEstoque {

    public void atualizarEstoque() {
        var arquivoProduto = new File("json/produto.json");

        try {
            var reader = new FileReader(arquivoProduto);
            var produtosArray = JsonParser.parseReader(reader).getAsJsonArray();

            var carrinho = carregarCarrinhoDoJSON();

            for (ItemCompraDTO itemCompra : carrinho) {
                var nomeProduto = itemCompra.getNome();
                int quantidadeDesejada = itemCompra.getQuantidadeDesejada();

                for (JsonElement produtoElement : produtosArray) {
                    var produtoJson = produtoElement.getAsJsonObject();
                    if (produtoJson.get("nome").getAsString().equals(nomeProduto)) {
                        var quantidadeAtual = produtoJson.get("quantidade").getAsInt();
                        produtoJson.addProperty("quantidade", quantidadeAtual - quantidadeDesejada);
                        break;
                    }
                }
            }

            var writer = new FileWriter(arquivoProduto);
            writer.write(new GsonBuilder().setPrettyPrinting().create().toJson(produtosArray));
            writer.close();

            System.out.println("Quantidade dos produtos atualizada com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<ItemCompraDTO> carregarCarrinhoDoJSON() {
        Gson gson = new Gson();
        JsonArray jsonArray;

        var file = new File("json/carrinho.json");

        try {
            var reader = new FileReader(file);
            jsonArray = gson.fromJson(reader, JsonArray.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao ler o arquivo JSON do carrinho");
        }

        ArrayList<ItemCompraDTO> carrinho = new ArrayList<>();
        for (JsonElement element : jsonArray) {
            var itemCompra = gson.fromJson(element, ItemCompraDTO.class);
            carrinho.add(itemCompra);
        }

        return carrinho;
    }
}
