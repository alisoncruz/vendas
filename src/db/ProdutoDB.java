package db;

import models.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDB {

    private List<Produto> produtosList = new ArrayList<>();

    public void addNovoProduto(Produto produto) {
        produtosList.add(produto);
    }

    public List<Produto> getProdutosList() {
        return produtosList;
    }
}
