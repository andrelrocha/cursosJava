package rocha.andre.json.utils.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import rocha.andre.json.DTO.ItemCompraDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@NoArgsConstructor
public class Compra {

    private int id;
    private LocalDateTime dataHora;
    private String nome;
    private ArrayList<ItemCompraDTO> itensCarrinho;


    private double valorSemDesconto;
    private double valorComDesconto;


    public Compra(String nome, LocalDateTime dataHora) {
        var random = new Random();
        this.id = random.nextInt(1000) + 1;
        this.dataHora = dataHora;
        this.nome = nome;
        this.itensCarrinho = new ArrayList<>();
    }

    @JsonCreator
    public Compra(@JsonProperty("id") int id, @JsonProperty("dataHora") LocalDateTime dataHora,
                  @JsonProperty("nome") String nome, @JsonProperty("valorSemDesconto") double valorSemDesconto,
                  @JsonProperty("valorComDesconto") double valorComDesconto,
                  @JsonProperty("itensCarrinho") ArrayList<ItemCompraDTO> itensCarrinho) {
        this.id = id;
        this.dataHora = dataHora;
        this.nome = nome;
        this.valorSemDesconto = valorSemDesconto;
        this.valorComDesconto = valorComDesconto;
        this.itensCarrinho = itensCarrinho;
    }

    public void adicionarItem(ItemCompraDTO item) {
        itensCarrinho.add(item);
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", dataHora=" + dataHora +
                ", nome='" + nome + '\'' +
                ", itensCarrinho=" + itensCarrinho +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<ItemCompraDTO> getItensCarrinho() {
        return itensCarrinho;
    }

    public double getValorSemDesconto() {
        return valorSemDesconto;
    }

    public void setValorSemDesconto(double valorSemDesconto) {
        this.valorSemDesconto = valorSemDesconto;
    }

    public double getValorComDesconto() {
        return valorComDesconto;
    }

    public void setValorComDesconto(double valorComDesconto) {
        this.valorComDesconto = valorComDesconto;
    }

}
