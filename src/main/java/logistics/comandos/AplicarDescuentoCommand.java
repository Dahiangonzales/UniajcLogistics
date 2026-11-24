package logistics.comandos;

import logistics.domain.Pedido;
import java.math.BigDecimal;

public class AplicarDescuentoCommand implements ComandoPedido {
    private final Pedido pedido;
    private final BigDecimal porcentaje;
    private BigDecimal totalAnterior;

    public AplicarDescuentoCommand(Pedido pedido, BigDecimal porcentaje) {
        this.pedido = pedido;
        this.porcentaje = porcentaje;
    }

    public void ejecutar() {
        totalAnterior = pedido.getTotal();
        pedido.setTotal(totalAnterior.multiply(BigDecimal.ONE.subtract(porcentaje.divide(new BigDecimal("100")))));
    }

    public void undo() {
        pedido.setTotal(totalAnterior);
    }
}

