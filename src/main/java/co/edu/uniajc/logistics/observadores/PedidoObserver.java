package co.edu.uniajc.logistics.observadores;

import co.edu.uniajc.logistics.domain.EstadoPedidoState;
import co.edu.uniajc.logistics.domain.Pedido;

public interface PedidoObserver {
    void actualizar(Pedido pedido, EstadoPedidoState anterior, EstadoPedidoState nuevo);
}
