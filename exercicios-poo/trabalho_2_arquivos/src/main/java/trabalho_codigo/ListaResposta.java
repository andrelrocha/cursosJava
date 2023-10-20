package trabalho_codigo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ListaResposta {
    public ArrayList<Object> criaListaRespostas(File gabaritoFile) {
        try {
            var leitor = new BufferedReader(new FileReader(gabaritoFile));
            var linha = "";
            var respostas = new ArrayList<>();

            while ((linha = leitor.readLine()) != null) {
                for (char c : linha.toCharArray()) {
                    if (c == 'V' || c == 'F') {
                        respostas.add(String.valueOf(c));
                    } else {
                        System.out.println("Caractere inválido: " + c);
                    }
                }
            }

            leitor.close();

            return respostas;
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }
    }
}
