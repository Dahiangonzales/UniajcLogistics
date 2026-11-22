package state;

import model.Pedido;

public interface EstadoPedido {
    String nombre();
    void pagar(Pedido pedido);
    void preparar(Pedido pedido);
    void enviar(Pedido pedido);
    void entregar(Pedido pedido);
    void cancelar(Pedido pedido);
}