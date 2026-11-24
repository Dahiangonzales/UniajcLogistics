package command;

import model.Pedido;

public class AplicarDescuentoCommand implements ComandoPedido {
    private final Pedido pedido;
    private final double montoDescuento;
    private double descuentoAnterior;
    private boolean aplicado = false;

    public AplicarDescuentoCommand(Pedido pedido, double montoDescuento) {
        this.pedido = pedido;
        this.montoDescuento = montoDescuento;
    }

    @Override
    public void ejecutar() {
        if ("Enviado".equals(pedido.getEstadoNombre()) || "Entregado".equals(pedido.getEstadoNombre())) {
            throw new IllegalStateException("No se puede aplicar descuento a un pedido ya enviado o entregado.");
        }
        this.descuentoAnterior = pedido.getDescuento();
        pedido.setDescuento(this.descuentoAnterior + montoDescuento);
        this.aplicado = true;
    }

    @Override
    public void deshacer() {
        if (!aplicado) {
            throw new IllegalStateException("No hay ningún descuento aplicado para deshacer.");
        }
        if ("Enviado".equals(pedido.getEstadoNombre()) || "Entregado".equals(pedido.getEstadoNombre())) {
            throw new IllegalStateException("No se puede revertir el descuento después de enviar el pedido.");
        }
        pedido.setDescuento(descuentoAnterior);
        this.aplicado = false;
    }
}
