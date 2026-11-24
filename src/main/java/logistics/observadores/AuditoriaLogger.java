package logistics.observadores;

import logistics.domain.EstadoPedidoState;
import logistics.domain.Pedido;

public class AuditoriaLogger implements PedidoObserver {
    public void actualizar(Pedido pedido, EstadoPedidoState anterior, EstadoPedidoState nuevo) {
        System.out.println("Auditoria: " + anterior.getClass().getSimpleName() + " -> " + nuevo.getClass().getSimpleName());
    }
}

