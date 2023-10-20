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
    private ListaAlunos listaAlunos;
    public Resultado(ListaAlunos lista) {
        this.listaAlunos = lista;
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
        var respostasLista = listaResposta.criaListaRespostas(gabaritoFile);

        var pathAlunos = "notas/" + disciplina + ".txt";
        var alunosFile = new File(pathAlunos);

        var listaAluno = new ListaAlunos();
        var alunos = listaAluno.listaNotasAlunos(alunosFile, respostasLista);

        //LOGICA DE CRIAR ARQUIVO COM O NOME E A PONTUAÇÃO, ORDENADO POR ORDEM ALFABETICA
        //LOGICADE CRIAR ARQUIVO COM O NOME E A PONTUAÇÃO, ORDENADO POR ORDEM DESCRESCENTE DE NOTA, COM A LINHA FINAL
        //SENDO A MÉDIA DA TURMA.

        //CASO TODAS AS RESPOSTAS SEJAM V OU F , A NOTA É 0
    }


}
