package state;

import model.Pedido;

public class EnPreparacionEstado implements EstadoPedido {
    @Override
    public String nombre() {
        return "EnPreparacion";
    }

    @Override
    public void pagar(Pedido pedido) {
        throw new IllegalStateException("El pedido ya fue Pagado.");
    }

    @Override
    public void preparar(Pedido pedido) {
        throw new IllegalStateException("El pedido ya está EnPreparacion.");
    }

    @Override
    public void enviar(Pedido pedido) {
        pedido.cambiarEstado(new EnviadoEstado());
    }

    @Override
    public void entregar(Pedido pedido) {
        throw new IllegalStateException("El pedido debe estar Enviado antes de Entregarse.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.cambiarEstado(new CanceladoEstado());
    }
}