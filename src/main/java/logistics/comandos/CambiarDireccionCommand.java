package logistics.comandos;

import logistics.domain.Pedido;

public class CambiarDireccionCommand implements ComandoPedido {
    private final Pedido pedido;
    private final String nuevaDireccion;
    private String direccionAnterior;

    public CambiarDireccionCommand(Pedido pedido, String nuevaDireccion) {
        this.pedido = pedido;
        this.nuevaDireccion = nuevaDireccion;
    }

    public void ejecutar() {
        System.out.println("Cambiando direccion a: " + nuevaDireccion);
    }

    public void undo() {
        System.out.println("Revirtiendo cambio de direccion");
    }
}

