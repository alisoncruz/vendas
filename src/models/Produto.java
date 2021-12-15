package models;

import java.time.LocalDate;

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

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return this.id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getPreco() {
        return preco;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }
}
