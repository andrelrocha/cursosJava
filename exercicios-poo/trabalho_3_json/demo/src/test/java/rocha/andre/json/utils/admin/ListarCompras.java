package rocha.andre.json.utils.admin;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.springframework.stereotype.Component;
import rocha.andre.json.DTO.PedidoSimplificadoDTO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class ListarCompras {

    public void listarCompras() {
        String filePath = "json/registros.json";
        File file = new File(filePath);

        var gson = new Gson();
        JsonArray jsonArray;

        try (FileReader reader = new FileReader(file)) {
            jsonArray = gson.fromJson(reader, JsonArray.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao ler o arquivo JSON");
        }

        double totalCompras = 0;
        for (JsonElement element : jsonArray) {
            PedidoSimplificadoDTO pedido = gson.fromJson(element, PedidoSimplificadoDTO.class);
            System.out.println(pedido + "\n");
            totalCompras += pedido.getValorComDesconto();
        }
        System.out.printf("Valor total das compras: R$ %.2f\n", totalCompras);
    }
}
