package trabalho_codigo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ListaAlunos {
    public ArrayList<Aluno> listaNotasAlunos(File notasFile, ArrayList<Object> listaRespostas) {
        try {
            var leitor = new BufferedReader(new FileReader(notasFile));
            var linha = "";
            ArrayList<Aluno> alunos = new ArrayList<>();

            while ((linha = leitor.readLine()) != null) {
                var newAluno = new Aluno();

                var tokens = linha.split("\t");
                System.out.println(tokens);

                if (tokens.length >= 2) {
                    var nome = tokens[1];
                    var respostas = tokens[0];

                    ArrayList<Character> listaRespostasParaSalvar = new ArrayList<>();

                    for (int i = 0; i < respostas.length(); i++) {
                        listaRespostasParaSalvar.add(respostas.charAt(i));
                    }

                    newAluno.setNome(nome);
                    newAluno.setRespostas(listaRespostasParaSalvar);

                    alunos.add(newAluno);
                }

            }

            return alunos;

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }
    }
}
