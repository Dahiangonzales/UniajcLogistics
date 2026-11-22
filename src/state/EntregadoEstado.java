package state;

import model.Pedido;

public class EntregadoEstado implements EstadoPedido {
    @Override
    public String nombre() {
        return "Entregado";
    }

    @Override
    public void pagar(Pedido pedido) {
        throw new IllegalStateException("El estado Entregado es terminal y no admite modificaciones.");
    }

    @Override
    public void preparar(Pedido pedido) {
        throw new IllegalStateException("El estado Entregado es terminal y no admite modificaciones.");
    }

    @Override
    public void enviar(Pedido pedido) {
        throw new IllegalStateException("El estado Entregado es terminal y no admite modificaciones.");
    }

    @Override
    public void entregar(Pedido pedido) {
        throw new IllegalStateException("El pedido ya fue Entregado.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("El estado Entregado es terminal y no admite modificaciones.");
    }
}