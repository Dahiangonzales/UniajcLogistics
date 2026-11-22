package state;

import model.Pedido;

public class PagadoEstado implements EstadoPedido {
    @Override
    public String nombre() {
        return "Pagado";
    }

    @Override
    public void pagar(Pedido pedido) {
        throw new IllegalStateException("El pedido ya está Pagado.");
    }

    @Override
    public void preparar(Pedido pedido) {
        pedido.cambiarEstado(new EnPreparacionEstado());
    }

    @Override
    public void enviar(Pedido pedido) {
        throw new IllegalStateException("El pedido debe estar EnPreparacion antes de Enviarse.");
    }

    @Override
    public void entregar(Pedido pedido) {
        throw new IllegalStateException("No se puede entregar un pedido Pagado.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.cambiarEstado(new CanceladoEstado());
    }
}
