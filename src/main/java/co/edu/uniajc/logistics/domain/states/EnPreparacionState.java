package co.edu.uniajc.logistics.domain.states;

import co.edu.uniajc.logistics.domain.*;
import co.edu.uniajc.logistics.domain.excepciones.TransicionInvalidaException;

public class EnPreparacionState implements EstadoPedidoState {
    public void pagar(Pedido pedido) {
        throw new TransicionInvalidaException("El pedido ya esta pagado");
    }
    public void preparar(Pedido pedido) {
        throw new TransicionInvalidaException("El pedido ya esta en preparacion");
    }
    public void enviar(Pedido pedido) {
        pedido.cambiarEstado(new EnviadoState());
    }
    public void entregar(Pedido pedido) {
        throw new TransicionInvalidaException("Transicion no permitida");
    }
    public void cancelar(Pedido pedido) {
        pedido.cambiarEstado(new CanceladoState());
    }
}
