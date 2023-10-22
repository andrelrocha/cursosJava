package trabalho_codigo.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PontuacaoDecrescente {
    private CalculaPontuacao pontuacao;
    public PontuacaoDecrescente(CalculaPontuacao calculaPontuacao) {
        this.pontuacao = calculaPontuacao;
    }

    public void ordenaAlunosPontDecrescente(ArrayList<Aluno> alunos, ArrayList<String> listaRespostas, String disciplina) {
        var pontuacao = new CalculaPontuacao();

        for (int i = 0; i < alunos.size(); i++) {
            for (int j = 0; j < alunos.size() - 1; j++) {
                var alunoAtual = alunos.get(j);
                var proximoAluno = alunos.get(j + 1);

                var pontuacaoAtual = pontuacao.calcularPontuacao(alunoAtual, listaRespostas);
                var pontuacaoProximo = pontuacao.calcularPontuacao(proximoAluno, listaRespostas);

                if (pontuacaoAtual < pontuacaoProximo) {
                    alunos.set(j, proximoAluno);
                    alunos.set(j + 1, alunoAtual);
                }
            }
        }

        try {
            var path = "notasOrdemDecrescente/" + disciplina + ".txt";
            var fileWriter = new FileWriter(path);
            var buffWriter = new BufferedWriter(fileWriter);

            for (Aluno a : alunos) {
                var pontAluno = pontuacao.calcularPontuacao(a, listaRespostas);
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
