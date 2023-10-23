package trabalho_codigo;

import trabalho_codigo.utils.*;

import java.io.File;
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

    private PontuacaoOrdemAlfabetica pontuacaoOrdemAlfabetica;
    public Resultado(PontuacaoOrdemAlfabetica pontuacao) {
        this.pontuacaoOrdemAlfabetica = pontuacao;
    }
    private CalculaPontuacao calculaPontuacao;
    public Resultado(CalculaPontuacao calculaPontuacao) {
        this.calculaPontuacao = calculaPontuacao;
    }

    private PontuacaoDecrescente pontuacaoDecrescente;
    public Resultado(PontuacaoDecrescente pontuacao) {
        this.pontuacaoDecrescente = pontuacao;
    }

    private ImprimeTXT imprimeTXT;
    public Resultado(ImprimeTXT imprime) {
        this.imprimeTXT = imprime;
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

        var pontuacao = new CalculaPontuacao();
        var listaAlunosAlfabetica = new PontuacaoOrdemAlfabetica(pontuacao);
        listaAlunosAlfabetica.OrdenaAlunosAlfabeto(alunos, respostasLista, disciplina);

        var listaAlunosNotasDecrescente = new PontuacaoDecrescente(pontuacao);
        listaAlunosNotasDecrescente.ordenaAlunosPontDecrescente(alunos, respostasLista, disciplina);

        var imprimeTxt = new ImprimeTXT();
        imprimeTxt.imprimeConteudoTXT("/notasOrdemAlfabetico/" + disciplina  + ".txt");
        imprimeTxt.imprimeConteudoTXT("/notasOrdemDecrescente" + disciplina + ".txt");

    }
}
