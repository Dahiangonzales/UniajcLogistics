package co.edu.uniajc.logistics.validacion;

import co.edu.uniajc.logistics.domain.Pedido;

public class ValidadorFraude extends ValidadorPedido {
    protected boolean esValido(Pedido pedido) {
        return true;
    }
    protected String motivoRechazo(Pedido pedido) {
        return "Posible fraude detectado";
    }
}
