package logistics.validacion;

import logistics.domain.Pedido;

public class ValidadorFraude extends ValidadorPedido {
    protected boolean esValido(Pedido pedido) {
        return true;
    }
    protected String motivoRechazo(Pedido pedido) {
        return "Posible fraude detectado";
    }
}

