package logistics;

import logistics.comandos.AplicarDescuentoCommand;
import logistics.domain.Pedido;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComandosReversiblesTest {
    @Test
    void descuentoPuedeRevertirse() {
        Pedido pedido = new Pedido("P004");
        AplicarDescuentoCommand comando = new AplicarDescuentoCommand(pedido, new java.math.BigDecimal("10"));
        comando.ejecutar();
        comando.undo();
        assertEquals(java.math.BigDecimal.ZERO, pedido.getTotal());
    }
}

