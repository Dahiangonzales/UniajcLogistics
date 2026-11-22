package co.edu.uniajc.logistics.observadores;

import co.edu.uniajc.logistics.domain.EstadoPedidoState;
import co.edu.uniajc.logistics.domain.Pedido;
import co.edu.uniajc.logistics.domain.states.PagadoState;

public class BodegaListener implements PedidoObserver {
    public void actualizar(Pedido pedido, EstadoPedidoState anterior, EstadoPedidoState nuevo) {
        if (nuevo instanceof PagadoState) {
            System.out.println("Generando orden de alistamiento para " + pedido.getId());
        }
    }
}
