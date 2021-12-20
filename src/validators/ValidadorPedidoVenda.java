package validators;

import models.PedidoVenda;

import java.util.ArrayList;
import java.util.List;

public class ValidadorPedidoVenda extends Validador {

    private PedidoVenda pedidoVenda;

    public List<IValidadorPedidoVenda> validadoresPedidoVendas = new ArrayList<>();

    @Override
    public boolean ehValido() {
        for(IValidadorPedidoVenda validador: this.validadoresPedidoVendas){
            String valido = validador.validar(this.pedidoVenda);

            if(!(valido == null)){
               this.getErros().add(valido);
            }
        }
          return !(this.getErros().size() > 0);
    }

    public ValidadorPedidoVenda(PedidoVenda pedidoVenda) {
        this.pedidoVenda = pedidoVenda;
        this.validadoresPedidoVendas.add(new ValidadorDataValidade());
        this.validadoresPedidoVendas.add(new ValidadorQuantidade());
    }
}
