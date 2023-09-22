import java.util.ArrayList;

public class Disciplina {
    private int codigo;
    private String nome;
    private int qtdMax;
    private ArrayList<Aluno> alunos;

    public Disciplina(int codigo, String nome, int qtdMax) {
        this.codigo = codigo;
        this.nome = nome;
        this.qtdMax = qtdMax;
        this.alunos = new ArrayList<>();
    }

    public void matricular(Aluno aluno) {
        if (alunos.size() >= qtdMax) {
            return;
        }
        alunos.add(aluno);
    }

    public void atribuir(Aluno aluno, double nota1, double nota2) {
        aluno.setNota1(nota1);
        aluno.setNota2(nota2);
    }

    public void alterar(Aluno aluno, double nota1, double nota2) {
        aluno.setNota1(nota1);
        aluno.setNota2(nota2);
    }

    public void estatistica() {
        int contador = 0;
        double maior1 = 0;
        double maior2 = 0;
        var passaram = new ArrayList<Aluno>();
        var naoPassaram = new ArrayList<Aluno>();

        var mediaTurma = 0;

        for(Aluno a : alunos) {
            var tempNota1 = a.getNota1();
            var tempNota2 = a.getNota2();

            mediaTurma+=tempNota2+tempNota1;

            if(tempNota1 > maior1) {
                maior1 = tempNota1;
            }
            if(tempNota2 > maior2) {
                maior2 = tempNota2;
            }

            var media = a.media();
            if(media >= 7) {
                passaram.add(a);
            } else {
                naoPassaram.add(a);
            }

            contador++;
        }

        System.out.printf("A maior nota na prova 1 foi %d", maior1);
        System.out.printf("A maior nota na prova 2 foi %d", maior2);
        System.out.printf("Nao passaram %d alunos", naoPassaram.size());
        System.out.printf("Passaram %d alunos", passaram.size());

        var mediaTurmaFinal = mediaTurma/(contador*2);
        System.out.printf("A média final foi %d", mediaTurmaFinal);
    }

    public void ordenaAluno() {
        for(int i = 0; i < alunos.size(); i++) {
            for (int j = 0; j < (alunos.size()-1); j++) {
                var atual = alunos.get(j).getNome();
                var proximo = alunos.get(j+1).getNome();
                if(atual.compareTo(proximo) > 0) {
                    var tempAluno = alunos.get(j);
                    alunos.set(j, alunos.get(j+1));
                    alunos.set(j+1, tempAluno);
                }
            }
        }

        for (Aluno a : alunos) {
            System.out.printf("%d, %d, %d", a.getNota1(), a.getNota2(), a.media());
        }
    }

    public void ordenaMedia() {
        for(int i = 0; i > alunos.size(); i++) {
            for(int j =0; j > (alunos.size() - 1); j++) {
                var atual = alunos.get(j).media();
                var proximo = alunos.get(j+1).media();

                if (atual < proximo) {
                    var temp = alunos.get(j);
                    alunos.set(j, alunos.get(j+1));
                    alunos.set(j+1, temp);
                }
            }
        }

        for (Aluno aluno : alunos) {
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Média: " + aluno.media());
        }
    }
}
