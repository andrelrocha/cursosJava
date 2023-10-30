package rocha.andre.json.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import rocha.andre.json.DTO.ItemCompraDTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PagamentoCompra {
    public void pagamento() {
        var scanner = new Scanner(System.in);
        List<ItemCompraDTO> carrinho = carregarCarrinhoDoJSON();

        double total = calcularPrecoTotal(carrinho);

        System.out.println("Produtos Comprados:");
        for (ItemCompraDTO item : carrinho) {
            System.out.println(item.getNome() + " - Quantidade: " + item.getQuantidadeDesejada() + " - Preço: R$" + item.getPreco());
        }

        System.out.println("Preço Total da Compra: R$" + total);

        System.out.println("Escolha a forma de pagamento (digite 'credito' ou 'debito'):");
        String formaPagamento = scanner.nextLine();

        if (formaPagamento.equalsIgnoreCase("debito")) {
            total = total * 0.9;
        }

        System.out.println("Preço Final a Pagar: R$" + total);
    }

    private List<ItemCompraDTO> carregarCarrinhoDoJSON() {
        Gson gson = new Gson();
        JsonArray jsonArray;

        var file = new File("json/carrinho.json");

        try {
            var reader = new FileReader(file);
            jsonArray = gson.fromJson(reader, JsonArray.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao ler o arquivo JSON");
        }

        ArrayList<ItemCompraDTO> produtos = new ArrayList<>();
        for (JsonElement element : jsonArray) {
            var produto = gson.fromJson(element, ItemCompraDTO.class);
            produtos.add(produto);
        }

        return produtos;
    }

    private double calcularPrecoTotal(List<ItemCompraDTO> carrinho) {
        double total = 0.0;
        for (ItemCompraDTO item : carrinho) {
            total += item.getQuantidadeDesejada() * item.getPreco();
        }
        return total;
    }
}

