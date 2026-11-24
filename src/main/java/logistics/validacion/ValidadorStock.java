package logistics.validacion;

import logistics.domain.Pedido;

public class ValidadorStock extends ValidadorPedido {
    protected boolean esValido(Pedido pedido) {
        return true;
    }
    protected String motivoRechazo(Pedido pedido) {
        return "Stock insuficiente";
    }
}

