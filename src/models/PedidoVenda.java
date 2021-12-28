package models;

import db.Estoque;

public class PedidoVenda {
    private int id;
    private Cliente cliente;
    private Produto produto;
    private int quantidade;
    private Double valorTotal;
    private Estoque estoque;

    public PedidoVenda() {
    }

    public PedidoVenda(Cliente cliente, Produto produto, int quantidade) {
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public PedidoVenda(Cliente cliente, Produto produto, int quantidade, Estoque estoque) {
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        this.estoque = estoque;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Estoque getEstoque() { return estoque; }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Double getValorTotal() {
        return getQuantidade() * getProduto().getPreco();
    }
}
