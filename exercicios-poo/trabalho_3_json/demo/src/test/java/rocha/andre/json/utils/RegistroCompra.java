package rocha.andre.json.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class RegistroCompra {

    private String filePath = "json/registros.json";

    private Gson gson;
    public RegistroCompra() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void registrarCompra(Compra compra) {
        JsonArray jsonArray;

        var file = new File(filePath);

        try {
            if (file.exists()) {
                var reader = new FileReader(file);
                jsonArray = gson.fromJson(reader, JsonArray.class);
            } else {
                jsonArray = new JsonArray();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao ler o arquivo JSON");
        }

        JsonObject jsonCompra = compraToJson(compra);
        jsonArray.add(jsonCompra);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(gson.toJson(jsonArray));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao escrever o arquivo JSON");
        }
    }

    private JsonObject compraToJson(Compra compra) {
        JsonObject jsonCompra = new JsonObject();
        jsonCompra.addProperty("id", compra.getId());
        jsonCompra.addProperty("dataHora", compra.getDataHora().toString());
        jsonCompra.addProperty("nome", compra.getNome());
        jsonCompra.addProperty("valorSemDesconto", compra.getValorSemDesconto());
        jsonCompra.addProperty("valorComDesconto", compra.getValorComDesconto());


        JsonArray itensCarrinho = new JsonArray();
        compra.getItensCarrinho().forEach(item -> {
            JsonObject jsonItem = new JsonObject();
            jsonItem.addProperty("nome", item.getNome());
            jsonItem.addProperty("quantidade", item.getQuantidadeDesejada());
            jsonItem.addProperty("preco", item.getPreco());
            jsonItem.addProperty("precoFinal", item.getPrecoFinal());
            itensCarrinho.add(jsonItem);
        });

        jsonCompra.add("itensCarrinho", itensCarrinho);

        return jsonCompra;
    }
}
