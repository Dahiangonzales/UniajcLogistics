package co.edu.uniajc.logistics.domain.states;

import co.edu.uniajc.logistics.domain.*;
import co.edu.uniajc.logistics.domain.excepciones.TransicionInvalidaException;

public class PendienteState implements EstadoPedidoState {
    public void pagar(Pedido pedido) {
        pedido.cambiarEstado(new PagadoState());
    }
    public void preparar(Pedido pedido) {
        throw new TransicionInvalidaException("No se puede preparar un pedido no pagado");
    }
    public void enviar(Pedido pedido) {
        throw new TransicionInvalidaException("Transicion no permitida");
    }
    public void entregar(Pedido pedido) {
        throw new TransicionInvalidaException("Transicion no permitida");
    }
    public void cancelar(Pedido pedido) {
        pedido.cambiarEstado(new CanceladoState());
    }
}
