package models;

import java.time.LocalDate;
import java.util.Objects;

public class Produto {
    private int id;
    private String descricao;
    private Double preco;
    private LocalDate dataValidade;

    public Produto() {
    }

    public Produto(int id, String descricao, Double preco, LocalDate dataValidade) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.dataValidade = dataValidade;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", dataValidade=" + dataValidade +
                '}';
    }
}
