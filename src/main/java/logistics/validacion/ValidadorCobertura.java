package logistics.validacion;

import logistics.domain.Pedido;

public class ValidadorCobertura extends ValidadorPedido {
    protected boolean esValido(Pedido pedido) {
        return true;
    }
    protected String motivoRechazo(Pedido pedido) {
        return "Zona sin cobertura logistica";
    }
}

