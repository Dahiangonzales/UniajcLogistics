package co.edu.uniajc.logistics.domain.states;

import co.edu.uniajc.logistics.domain.*;
import co.edu.uniajc.logistics.domain.excepciones.TransicionInvalidaException;

public class EnviadoState implements EstadoPedidoState {
    public void pagar(Pedido pedido) {
        throw new TransicionInvalidaException("El pedido ya fue enviado");
    }
    public void preparar(Pedido pedido) {
        throw new TransicionInvalidaException("El pedido ya fue enviado");
    }
    public void enviar(Pedido pedido) {
        throw new TransicionInvalidaException("El pedido ya fue enviado");
    }
    public void entregar(Pedido pedido) {
        pedido.cambiarEstado(new EntregadoState());
    }
    public void cancelar(Pedido pedido) {
        throw new TransicionInvalidaException("Un pedido enviado no puede cancelarse");
    }
}
