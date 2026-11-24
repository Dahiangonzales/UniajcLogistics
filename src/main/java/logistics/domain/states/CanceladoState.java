package logistics.domain.states;

import logistics.domain.*;
import logistics.domain.excepciones.TransicionInvalidaException;

public class CanceladoState implements EstadoPedidoState {
    public void pagar(Pedido pedido) {
        throw new TransicionInvalidaException("El pedido esta cancelado");
    }
    public void preparar(Pedido pedido) {
        throw new TransicionInvalidaException("El pedido esta cancelado");
    }
    public void enviar(Pedido pedido) {
        throw new TransicionInvalidaException("El pedido esta cancelado");
    }
    public void entregar(Pedido pedido) {
        throw new TransicionInvalidaException("El pedido esta cancelado");
    }
    public void cancelar(Pedido pedido) {
        throw new TransicionInvalidaException("El pedido ya esta cancelado");
    }
}

