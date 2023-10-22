package trabalho_codigo.utils;

import java.util.ArrayList;

public class CalculaPontuacao {
    public int calcularPontuacao(Aluno aluno, ArrayList<String> listaRespostas) {
        var respostasAluno = aluno.getRespostas();
        System.out.println(respostasAluno);
        int pontuacao = 0;

        if (respostasAluno.size() == listaRespostas.size()) {
            for (int i = 0; i < respostasAluno.size(); i++) {
                System.out.println("resposta aluno: " + respostasAluno.get(i));

                System.out.println("resposta prova: " + listaRespostas.get(i));

                System.out.println("condição:" + respostasAluno.get(i).equals(listaRespostas.get(i)));


                if (respostasAluno.get(i).equals(listaRespostas.get(i))) {
                    pontuacao++;
                    System.out.printf("Pontuação: %d", pontuacao);
                }
            }
        }

        return pontuacao;
    }
}
