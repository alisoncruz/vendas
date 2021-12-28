package db;

import models.Produto;

import java.util.*;

public class EstoquesDB {

    private Map<String, Estoque> estoqueMap = new HashMap<>();

    public Map<String, Estoque> getEstoqueMap() {
        return estoqueMap;
    }

    public void addNovoEstoque(Estoque estoque) {
        getEstoqueMap().put(estoque.getId(), estoque);
    }

    public List<Estoque> getEstoqueList() {
        List<Estoque> estoques = new ArrayList<>();

        for (Map.Entry<String, Estoque> estoqueEntry : this.getEstoqueMap().entrySet()) {
            Estoque estoque = estoqueEntry.getValue();
            estoques.add(estoque);
        }
        return estoques;
    }

    public Estoque getEstoqueByProduto(Produto produto) {
        Optional<Estoque> estoqueOptional = this.getEstoqueList().stream()
                .filter(estoque -> estoque.getProduto().getId() == produto.getId()).findAny();
        if (estoqueOptional.isPresent()) {
            return estoqueOptional.get();
        } else {
            throw new RuntimeException("Produto sem estoque.");
        }

    }

}
