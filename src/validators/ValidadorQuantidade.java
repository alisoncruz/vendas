package validators;

import models.PedidoVenda;

public class ValidadorQuantidade implements IValidadorPedidoVenda {
    @Override
    public String validar(PedidoVenda pedidoVenda) {
        if (pedidoVenda.getQuantidade() > pedidoVenda.getEstoque().getQuantidade()) {
            return "A quantidade do pedido é maior que a do estoque";
        }
        return null;
    }
}
