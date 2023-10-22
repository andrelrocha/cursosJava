package trabalho_codigo.utils;

import java.util.ArrayList;

public class Aluno {
    private ArrayList<String> respostas;
    private String nome;


    public ArrayList<String> getRespostas() {
        return respostas;
    }

    public void setRespostas(ArrayList<String> respostas) {
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
