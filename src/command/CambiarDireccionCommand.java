package command;

import model.Pedido;

public class CambiarDireccionCommand implements ComandoPedido {
    private final Pedido pedido;
    private final String nuevaDireccion;
    private String direccionAnterior;
    private boolean aplicado = false;

    public CambiarDireccionCommand(Pedido pedido, String nuevaDireccion) {
        this.pedido = pedido;
        this.nuevaDireccion = nuevaDireccion;
    }

    @Override
    public void ejecutar() {
        if ("Enviado".equals(pedido.getEstadoNombre()) || "Entregado".equals(pedido.getEstadoNombre())) {
            throw new IllegalStateException("No se puede cambiar la dirección de un pedido ya enviado o entregado.");
        }
        this.direccionAnterior = pedido.getDireccionEntrega();
        pedido.setDireccionEntrega(nuevaDireccion);
        this.aplicado = true;
    }

    @Override
    public void deshacer() {
        if (!aplicado) {
            throw new IllegalStateException("No hay ningún cambio de dirección para deshacer.");
        }
        if ("Enviado".equals(pedido.getEstadoNombre()) || "Entregado".equals(pedido.getEstadoNombre())) {
            throw new IllegalStateException("No se puede revertir la dirección después de enviar el pedido.");
        }
        pedido.setDireccionEntrega(direccionAnterior);
        this.aplicado = false;
    }
}
