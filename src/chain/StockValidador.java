package chain;

import model.Pedido;

public class StockValidador extends ValidadorPedido {
    @Override
    protected ResultadoValidacion comprobar(Pedido pedido) {
        if (pedido.getCantidadSolicitada() > pedido.getStockDisponible()) {
            return ResultadoValidacion.error("Stock insuficiente para el pedido " + pedido.getId());
        }
        return ResultadoValidacion.ok();
    }
}
