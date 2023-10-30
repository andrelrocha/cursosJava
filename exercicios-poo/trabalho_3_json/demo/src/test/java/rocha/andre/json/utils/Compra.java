package rocha.andre.json.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import rocha.andre.json.DTO.ItemCompraDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

@Component
public class Compra {

    private int id;
    private LocalDateTime dataHora;
    private String nome;
    private ArrayList<ItemCompraDTO> itensCarrinho;


    public Compra(String nome, LocalDateTime dataHora) {
        var random = new Random();
        this.id = random.nextInt(1000) + 1;
        this.dataHora = dataHora;
        this.nome = nome;
        this.itensCarrinho = new ArrayList<>();
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

}
