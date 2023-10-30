package rocha.andre.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rocha.andre.json.utils.*;

import java.util.Scanner;

@SpringBootApplication
public class Hub {
    /*
    @Autowired
    private CriarProduto criarProduto;
    @Autowired
    private EditarProduto editarProduto;
    @Autowired
    private Carrinho carrinho;
    @Autowired
    private PagamentoCompra pagamentoCompra;
    @Autowired
    private AtualizaEstoque atualizaEstoque;
    @Autowired
    private RegistroCompra registroCompra;

     */

    public static void main(String[] args) {
        System.out.println("Você é cliente ou adminstrador?\n");
        Scanner scanner = new Scanner(System.in);
        var user = scanner.nextLine();

        if (user.equals("administrador")) {
            while(true) {
                System.out.println("Digite o numero da operação desejada ou 'sair'\n");
                System.out.println("1-criar produto\n2-editar produto");
                var entrada = scanner.nextLine();

                if (entrada.equalsIgnoreCase("sair")) {
                    break;
                }

                if (entrada.matches("\\d+")) {
                    int esc = Integer.parseInt(entrada);

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
                            // CASE PARA DELETAR UM PRODUTO
                            System.out.println("Opção 3 selecionada.");
                            break;

                        case 4:
                            // CASE PARA LISTAR COMPRAS
                            System.out.println("Opção 4 selecionada.");
                            break;

                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                } else {
                    System.out.println("Digite um número válido ou 'sair'.");
                }
            }
        }

        if (user.equals("cliente")) {
            var carrinho = new Carrinho();
            carrinho.executar();

            var pagamento = new PagamentoCompra();
            var compra = pagamento.pagamento();

            var atualizarEstoque = new AtualizaEstoque();
            atualizarEstoque.atualizarEstoque();

            var registroCompra = new RegistroCompra();
            registroCompra.registrarCompra(compra);
        }
    }
}
