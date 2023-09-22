import java.util.ArrayList;

public class Compra {
    private ArrayList<ItemDeCompra> itensDeCompra;

    public void inserirItem(ItemDeCompra itemDeCompra) {
        itensDeCompra = new ArrayList<>();
        itensDeCompra.add(itemDeCompra);
    }

    public void calcularTotalCompra() {
        int tamanho = 0;
        for (ItemDeCompra i : itensDeCompra) {
            if (i == null) {
                break;
            }
            System.out.println(itensDeCompra.get(tamanho).calcularTotal());
        }
    }

    public void darDesconto(double desconto) {
        int tamanho = 0;

        for (ItemDeCompra i : itensDeCompra) {
            if (i == null) {
                break;
            }
            double valorOriginal = i.getPreco();
            double valorFinal = valorOriginal*desconto;

            System.out.println(valorOriginal-valorFinal);

            i.setPreco(valorFinal);
        }
    }

    public void calcularTotalFinal() {
        int tamanho = 0;

        for (ItemDeCompra i : itensDeCompra) {
            if (i == null) {
                break;
            }

            System.out.println(i.getPreco());
        }
    }

    public void gerarRelatorio() {
        for (ItemDeCompra i : itensDeCompra) {
            if (i == null) {
                break;
            }
            System.out.println(i.getNomeProduto());
            System.out.println();
            System.out.println(i.getNomeProduto());
            System.out.println(i.getNomeProduto());
        }
    }

}
