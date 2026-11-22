package state;

import model.Pedido;

public class PendienteEstado implements EstadoPedido {
    @Override
    public String nombre() {
        return "Pendiente";
    }

    @Override
    public void pagar(Pedido pedido) {
        pedido.cambiarEstado(new PagadoEstado());
    }

    @Override
    public void preparar(Pedido pedido) {
        throw new IllegalStateException("No se puede pasar a EnPreparacion si no está Pagado.");
    }

    @Override
    public void enviar(Pedido pedido) {
        throw new IllegalStateException("No se puede enviar un pedido Pendiente.");
    }

    @Override
    public void entregar(Pedido pedido) {
        throw new IllegalStateException("No se puede entregar un pedido Pendiente.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.cambiarEstado(new CanceladoEstado());
    }
}