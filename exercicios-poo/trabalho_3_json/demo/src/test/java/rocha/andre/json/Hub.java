package rocha.andre.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hub {
    @Autowired
    private CriarProduto criarProduto;
    @Autowired
    private EditarProduto editarProduto;
    @Autowired
    private Carrinho carrinho;

    public static void main(String[] args) {
        /*
        var criarProduto = new CriarProduto();
        criarProduto.criarProduto();

        var editarProduto = new EditarProduto();
        editarProduto.editarProduto();
        */
         var carrinho = new Carrinho();
         carrinho.executar();
    }
}
