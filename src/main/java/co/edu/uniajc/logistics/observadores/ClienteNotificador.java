package co.edu.uniajc.logistics.observadores;

import co.edu.uniajc.logistics.domain.EstadoPedidoState;
import co.edu.uniajc.logistics.domain.Pedido;

public class ClienteNotificador implements PedidoObserver {
    public void actualizar(Pedido pedido, EstadoPedidoState anterior, EstadoPedidoState nuevo) {
        System.out.println("Notificando al cliente: nuevo estado " + nuevo.getClass().getSimpleName());
    }
}
