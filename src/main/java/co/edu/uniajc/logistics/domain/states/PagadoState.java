package co.edu.uniajc.logistics.domain.states;

import co.edu.uniajc.logistics.domain.*;
import co.edu.uniajc.logistics.domain.excepciones.TransicionInvalidaException;

public class PagadoState implements EstadoPedidoState {
    public void pagar(Pedido pedido) {
        throw new TransicionInvalidaException("El pedido ya esta pagado");
    }
    public void preparar(Pedido pedido) {
        pedido.cambiarEstado(new EnPreparacionState());
    }
    public void enviar(Pedido pedido) {
        throw new TransicionInvalidaException("Debe prepararse antes de enviarse");
    }
    public void entregar(Pedido pedido) {
        throw new TransicionInvalidaException("Transicion no permitida");
    }
    public void cancelar(Pedido pedido) {
        pedido.cambiarEstado(new CanceladoState());
    }
}
