package chain;

import model.Pedido;

public class CoberturaValidador extends ValidadorPedido {
    @Override
    protected ResultadoValidacion comprobar(Pedido pedido) {
        if (!pedido.isZonaConCobertura()) {
            return ResultadoValidacion.error("Sin cobertura logística para la dirección de destino");
        }
        return ResultadoValidacion.ok();
    }
}