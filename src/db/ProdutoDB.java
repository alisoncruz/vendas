package db;

import models.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdutoDB {

    private Map<Integer, Produto> produtosList = new HashMap();

    public void addNovoProduto(Produto produto) {
        produtosList.put(produto.getId(), produto);
    }

    public List<Produto> getProdutosList() {
        List<Produto> produtos = new ArrayList<>();

        for (Map.Entry<Integer, Produto> produtoEntry : produtosList.entrySet()) {
            produtos.add(produtoEntry.getValue());
        }
        return produtos;

    }

    public Produto getProdutoByID(int produtoId) {
        Produto produto = produtosList.get(produtoId);
        return produto;
    }
}
