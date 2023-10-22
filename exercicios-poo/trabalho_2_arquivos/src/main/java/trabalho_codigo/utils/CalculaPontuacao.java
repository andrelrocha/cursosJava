package trabalho_codigo.utils;

import java.util.ArrayList;

public class CalculaPontuacao {
    public int calcularPontuacao(Aluno aluno, ArrayList<String> listaRespostas) {
        var respostasAluno = aluno.getRespostas();
        int pontuacao = 0;

        if (respostasAluno.size() == listaRespostas.size()) {
            for (int i = 0; i < respostasAluno.size(); i++) {
                if (respostasAluno.get(i).equals(listaRespostas.get(i))) {
                    pontuacao++;
                }
            }
        }

        return pontuacao;
    }
}
