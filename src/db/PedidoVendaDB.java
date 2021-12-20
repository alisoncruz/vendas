package db;

import models.PedidoVenda;

import java.util.ArrayList;
import java.util.List;

public class PedidoVendaDB {

    private List<PedidoVenda> pedidoVendas = new ArrayList<>();

    public List<PedidoVenda> getPedidoVendas() {
        return pedidoVendas;
    }

    public void addNovoPedido(PedidoVenda pedidoVenda) {
        int id = pedidoVendas.size() + 1;
        pedidoVenda.setId(id);
        getPedidoVendas().add(pedidoVenda);
    }
}
