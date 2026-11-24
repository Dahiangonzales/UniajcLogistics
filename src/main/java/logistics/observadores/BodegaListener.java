package logistics.observadores;

import logistics.domain.EstadoPedidoState;
import logistics.domain.Pedido;
import logistics.domain.states.PagadoState;

public class BodegaListener implements PedidoObserver {
    public void actualizar(Pedido pedido, EstadoPedidoState anterior, EstadoPedidoState nuevo) {
        if (nuevo instanceof PagadoState) {
            System.out.println("Generando orden de alistamiento para " + pedido.getId());
        }
    }
}

