package logistics.observadores;

import logistics.domain.EstadoPedidoState;
import logistics.domain.Pedido;

public class ClienteNotificador implements PedidoObserver {
    public void actualizar(Pedido pedido, EstadoPedidoState anterior, EstadoPedidoState nuevo) {
        System.out.println("Notificando al cliente: nuevo estado " + nuevo.getClass().getSimpleName());
    }
}

