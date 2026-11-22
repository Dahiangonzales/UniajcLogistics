
package observer;

public class BodegaListener implements PedidoObservador {
    @Override
    public void actualizar(EventoPedido evento) {
        if ("Pagado".equals(evento.estadoNuevo())) {
            System.out.printf("[Bodega] Generando orden de alistamiento para pedido %s%n",
                    evento.pedidoId());
        }
    }
}