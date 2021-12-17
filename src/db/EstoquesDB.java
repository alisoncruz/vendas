package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstoquesDB {

    private Map<String, Estoque> estoqueMap = new HashMap<>();

    public Map<String, Estoque> getEstoqueMap() {
        return estoqueMap;
    }

    public void addNovoEstoque(Estoque estoque){
        getEstoqueMap().put(estoque.getId(), estoque);
    }

    public List<Estoque> getEstoqueList(){
        List<Estoque> estoques = new ArrayList<>();

        for(Map.Entry<String,Estoque> estoqueEntry: this.getEstoqueMap().entrySet()){
            Estoque estoque = estoqueEntry.getValue();
            estoques.add(estoque);
        }
        return estoques;
    }

}
