package logistics.domain;

public interface EstadoPedidoState {
    void pagar(Pedido pedido);
    void preparar(Pedido pedido);
    void enviar(Pedido pedido);
    void entregar(Pedido pedido);
    void cancelar(Pedido pedido);
}

