package trabalho_codigo;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class SalvaNota {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Digite o nome da disciplina: ");
        var disciplina = scanner.nextLine();

        var sair = false;

        try {
            var notasDir = new File("notas");
            if (!notasDir.exists()) {
                notasDir.mkdirs();
            }

            var path = "notas/" + disciplina + ".txt";

            var fileWriter = new FileWriter(path);
            var buffWriter = new BufferedWriter(fileWriter);

            System.out.println("Digite as respostas dos alunos para as 10 questões (V ou F) e seus nomes. Digite 'sair' para encerrar.");

            while (true) {
                System.out.print("Respostas para as 10 questões (V ou F): ");
                var respostas = "";

                for (int i = 0; i < 10; i++) {
                    System.out.printf("%dª questão: ", i+1);
                    var resposta = scanner.next();

                    if (resposta.equals("sair")) {
                        sair = true;
                        break;
                    }

                    var respostaCaractere = resposta.charAt(0);

                    respostas += respostaCaractere;
                }
                if (sair == true) {
                    break;
                }

                respostas += "\t";

                System.out.print("Nome do aluno: ");
                var nome = scanner.next();
                if (nome.equals("sair")) {
                    break;
                }

                var linha = respostas + nome;
                buffWriter.write(linha);
                buffWriter.newLine();
            }

            buffWriter.close();
            System.out.println("Arquivo criado com sucesso!");
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao criar o arquivo: " + e.getMessage());
        }
    }
}
