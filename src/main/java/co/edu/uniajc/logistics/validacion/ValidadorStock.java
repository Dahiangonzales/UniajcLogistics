package co.edu.uniajc.logistics.validacion;

import co.edu.uniajc.logistics.domain.Pedido;

public class ValidadorStock extends ValidadorPedido {
    protected boolean esValido(Pedido pedido) {
        return true;
    }
    protected String motivoRechazo(Pedido pedido) {
        return "Stock insuficiente";
    }
}
