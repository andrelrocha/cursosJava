package trabalho_codigo.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ImprimeTXT {
    public void imprimeConteudoTXT(String file) {
        try {
            var leitor = new BufferedReader(new FileReader(file));
            var linha = "";

            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }

            leitor.close();

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
