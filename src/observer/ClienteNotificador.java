package observer;

public class ClienteNotificador implements PedidoObservador {
    @Override
    public void actualizar(EventoPedido evento) {
        System.out.printf("[Cliente] Pedido %s cambió de %s a %s%n",
                evento.pedidoId(), evento.estadoAnterior(), evento.estadoNuevo());
    }
}
