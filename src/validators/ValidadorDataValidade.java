package validators;

import models.PedidoVenda;

import java.time.LocalDate;

public class ValidadorDataValidade implements IValidadorPedidoVenda {
    @Override
    public String validar(PedidoVenda pedidoVenda) {
        if(pedidoVenda.getProduto().getDataValidade().isBefore(LocalDate.now())){
            return "Produto fora do prazo de validade";
        }
        return null;
    }
}
