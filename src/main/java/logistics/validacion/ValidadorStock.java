package logistics.validacion;

import logistics.domain.Pedido;

public class ValidadorStock extends ValidadorPedido {
    private final boolean stockDisponible;

    public ValidadorStock(boolean stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    @Override
    protected boolean esValido(Pedido pedido) {
        return stockDisponible;
    }

    @Override
    protected String motivoRechazo(Pedido pedido) {
        return "Stock insuficiente para el pedido " + pedido.getId();
    }
}
