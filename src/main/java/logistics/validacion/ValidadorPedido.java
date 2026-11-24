package logistics.validacion;

import logistics.domain.Pedido;

public abstract class ValidadorPedido {
    private ValidadorPedido siguiente;

    public ValidadorPedido conectarCon(ValidadorPedido siguiente) {
        this.siguiente = siguiente;
        return siguiente;
    }

    public void validar(Pedido pedido) {
        if (!esValido(pedido)) {
            throw new IllegalArgumentException(motivoRechazo(pedido));
        }
        if (siguiente != null) {
            siguiente.validar(pedido);
        }
    }

    protected abstract boolean esValido(Pedido pedido);
    protected abstract String motivoRechazo(Pedido pedido);
}

