package logistics.domain.states;

import logistics.domain.*;
import logistics.domain.excepciones.TransicionInvalidaException;

public class EntregadoState implements EstadoPedidoState {
    public void pagar(Pedido pedido) {
        throw new TransicionInvalidaException("El pedido ya fue entregado");
    }
    public void preparar(Pedido pedido) {
        throw new TransicionInvalidaException("El pedido ya fue entregado");
    }
    public void enviar(Pedido pedido) {
        throw new TransicionInvalidaException("El pedido ya fue entregado");
    }
    public void entregar(Pedido pedido) {
        throw new TransicionInvalidaException("El pedido ya fue entregado");
    }
    public void cancelar(Pedido pedido) {
        throw new TransicionInvalidaException("El pedido ya fue entregado");
    }
}

