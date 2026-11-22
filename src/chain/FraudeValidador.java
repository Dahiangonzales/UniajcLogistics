package chain;

import model.Pedido;

public class FraudeValidador extends ValidadorPedido {
    private static final double UMBRAL_SOSPECHOSO = 2000.0;

    @Override
    protected ResultadoValidacion comprobar(Pedido pedido) {
        if (pedido.getSubtotal() > UMBRAL_SOSPECHOSO && !pedido.isClienteConHistorial()) {
            return ResultadoValidacion.error("Monto sospechoso sin historial previo del cliente");
        }
        return ResultadoValidacion.ok();
    }
}