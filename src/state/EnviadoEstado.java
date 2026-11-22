package state;

import model.Pedido;

public class EnviadoEstado implements EstadoPedido {
    @Override
    public String nombre() {
        return "Enviado";
    }

    @Override
    public void pagar(Pedido pedido) {
        throw new IllegalStateException("El pedido ya fue Pagado.");
    }

    @Override
    public void preparar(Pedido pedido) {
        throw new IllegalStateException("El pedido ya fue Enviado.");
    }

    @Override
    public void enviar(Pedido pedido) {
        throw new IllegalStateException("El pedido ya está Enviado.");
    }

    @Override
    public void entregar(Pedido pedido) {
        pedido.cambiarEstado(new EntregadoEstado());
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("No se puede cancelar un pedido que ya fue Enviado.");
    }
}
