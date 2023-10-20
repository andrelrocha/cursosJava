package trabalho_codigo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Resultado {
    private ListaResposta listaResposta;
    public Resultado(ListaResposta lista) {
        this.listaResposta = lista;
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Digite o nome da disciplina: ");
        var disciplina = scanner.nextLine();
        String gabaritoFilePath = "notas/gabarito/" + disciplina + ".txt";
        var gabaritoFile = new File(gabaritoFilePath);

        if (!gabaritoFile.exists()) {
            System.out.println("Arquivo do gabarito não encontrado.");
            return;
        }

        var listaResposta = new ListaResposta();
        var repostasLista = listaResposta.criaListaRespostas(gabaritoFile);

    }


}
