package trabalho_codigo;

import java.util.ArrayList;

public class Aluno {
    private ArrayList<Character> respostas;
    private String nome;


    public ArrayList<Character> getRespostas() {
        return respostas;
    }

    public void setRespostas(ArrayList<Character> respostas) {
        this.respostas = respostas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "respostas=" + respostas +
                ", nome='" + nome + '\'' +
                '}';
    }
}
