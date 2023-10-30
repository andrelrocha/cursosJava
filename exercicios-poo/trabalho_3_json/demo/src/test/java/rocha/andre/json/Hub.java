package rocha.andre.json;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import rocha.andre.json.utils.admin.ApagarProduto;
import rocha.andre.json.utils.admin.CriarProduto;
import rocha.andre.json.utils.admin.EditarProduto;
import rocha.andre.json.utils.admin.ListarCompras;
import rocha.andre.json.utils.client.AtualizaEstoque;
import rocha.andre.json.utils.client.Carrinho;
import rocha.andre.json.utils.client.PagamentoCompra;
import rocha.andre.json.utils.client.RegistroCompra;

import java.io.IOException;
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

    public static void main(String[] args) throws IOException {
        System.out.println("Você é cliente ou administrador?\n");
        Scanner scanner = new Scanner(System.in);
        var user = scanner.nextLine();

        if (user.equals("administrador")) {
            while(true) {
                System.out.println("Digite o numero da operação desejada ou 'sair'\n");
                System.out.println("1-criar produto\n2-editar produto\n3-apagar produto\n4-listar compras\n");
                var entrada = scanner.nextLine();

                if (entrada.equalsIgnoreCase("sair")) {
                    break;
                }

                if (entrada.matches("\\d+")) {
                    int esc = Integer.parseInt(entrada);

                    switch (esc) {
                        case 1:
                            var criaProduto = new CriarProduto();
                            criaProduto.criarProduto();
                            break;

                        case 2:
                            var editaProduto = new EditarProduto();
                            editaProduto.editarProduto();
                            break;

                        case 3:
                            var apagaProduto = new ApagarProduto();
                            apagaProduto.apagarProduto();
                            break;

                        case 4:
                            var listaCompras = new ListarCompras();
                            listaCompras.listarCompras();
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
