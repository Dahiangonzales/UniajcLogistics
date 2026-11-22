package state;

import model.Pedido;

public class CanceladoEstado implements EstadoPedido {
    @Override
    public String nombre() {
        return "Cancelado";
    }

    @Override
    public void pagar(Pedido pedido) {
        throw new IllegalStateException("El pedido está Cancelado y no admite cambios.");
    }

    @Override
    public void preparar(Pedido pedido) {
        throw new IllegalStateException("El pedido está Cancelado y no admite cambios.");
    }

    @Override
    public void enviar(Pedido pedido) {
        throw new IllegalStateException("El pedido está Cancelado y no admite cambios.");
    }

    @Override
    public void entregar(Pedido pedido) {
        throw new IllegalStateException("El pedido está Cancelado y no admite cambios.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("El pedido ya está Cancelado.");
    }
}