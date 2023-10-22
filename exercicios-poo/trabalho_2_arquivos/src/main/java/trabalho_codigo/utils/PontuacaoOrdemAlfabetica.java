package trabalho_codigo.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PontuacaoOrdemAlfabetica {
    private CalculaPontuacao pontuacao;
    public PontuacaoOrdemAlfabetica(CalculaPontuacao calculaPontuacao) {
        this.pontuacao = calculaPontuacao;
    }

    public void OrdenaAlunosAlfabeto(ArrayList<Aluno> alunos, ArrayList<String> listaRespostas, String disciplina) {
        var pontuacao = new CalculaPontuacao();

        try {
            var path = "notasOrdemAlfabetico/" + disciplina + ".txt";
            var fileWriter = new FileWriter(path);
            var buffWriter = new BufferedWriter(fileWriter);

            for (Aluno a : alunos) {
                var pontAluno = pontuacao.calcularPontuacao(a, listaRespostas);
                System.out.println(pontAluno);
                var linha = a.getNome() + "\t" + pontAluno;

                buffWriter.write(linha);
                buffWriter.newLine();
            }

            buffWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Algo aconteceu: " + e.getMessage());
        }
    }
}
