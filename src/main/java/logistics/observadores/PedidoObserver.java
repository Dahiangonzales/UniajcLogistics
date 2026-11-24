package logistics.observadores;

import logistics.domain.EstadoPedidoState;
import logistics.domain.Pedido;

public interface PedidoObserver {
    void actualizar(Pedido pedido, EstadoPedidoState anterior, EstadoPedidoState nuevo);
}

