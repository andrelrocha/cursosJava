package rocha.andre.json.utils.client;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.springframework.stereotype.Component;
import rocha.andre.json.DTO.ItemCompraDTO;
import rocha.andre.json.utils.client.Compra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class PagamentoCompra {
    public Compra pagamento() {
        var scanner = new Scanner(System.in);
        System.out.println("Qual o seu nome?");
        String nome = scanner.nextLine();
        var now = LocalDateTime.now();
        Compra compra = new Compra(nome, now);

        List<ItemCompraDTO> carrinho = carregarCarrinhoDoJSON();

        double total = calcularPrecoTotal(carrinho);

        System.out.println("Escolha a forma de pagamento (digite 'credito' ou 'debito'):");
        String formaPagamento = scanner.nextLine();
        var valorFinalComDesconto = total;

        if (formaPagamento.equalsIgnoreCase("debito")) {
            valorFinalComDesconto = total * 0.9;
        }

        System.out.println("Produtos Comprados:");
        for (ItemCompraDTO item : carrinho) {
            double precoDesconto = item.getPreco() * 0.9;
            item.setPrecoFinal(precoDesconto);
            compra.adicionarItem(item);
            System.out.println(item.getNome() + " - Quantidade: " + item.getQuantidadeDesejada() + " - Preço: R$" + item.getPreco());
        }

        compra.setValorSemDesconto(total);
        compra.setValorComDesconto(valorFinalComDesconto);

        System.out.println("Preço Total da Compra: R$" + total);
        System.out.println("Preço Final a Pagar: R$" + valorFinalComDesconto);

        return compra;
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

