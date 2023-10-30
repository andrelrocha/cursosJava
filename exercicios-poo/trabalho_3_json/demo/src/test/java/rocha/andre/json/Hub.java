package rocha.andre.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Hub {
    @Autowired
    private CriarProduto criarProduto;
    @Autowired
    private EditarProduto editarProduto;
    @Autowired
    private Carrinho carrinho;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var user = scanner.nextLine();

        if (user.equals("administrador")) {
            while(true) {
                System.out.println("Digite o numero da operação desejada ou 'sair'\n");
                System.out.println();
                var esc = scanner.nextInt();

                switch (esc) {
                    case 1:
                        var criarProduto = new CriarProduto();
                        criarProduto.criarProduto();
                        break;

                    case 2:
                        var editarProduto = new EditarProduto();
                        editarProduto.editarProduto();
                        break;

                    case 3:
                        //CASE PARA DELETAR UM PRODUTO
                        System.out.println("Opção 3 selecionada.");
                        break;

                    case 4:
                        //CASE PARA LISTAR COMPRAS
                        System.out.println("Opção 3 selecionada.");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            }
        }

        if (user.equals("cliente")) {
            System.out.println("Digite o numero da operação desejada ou 'sair'\n");
            System.out.println();
            var esc = scanner.nextInt();

            switch (esc) {
                case 1:
                    var carrinho = new Carrinho();
                    carrinho.executar();
                    break;

                case 2:
                    //
                    break;

                case 3:
                    //
                    System.out.println("Opção 3 selecionada.");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }


    }
}
