package logistics;

import logistics.domain.Pedido;
import logistics.domain.excepciones.TransicionInvalidaException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CicloVidaPedidoTest {
    @Test
    void pedidoPendientePuedePagar() {
        Pedido pedido = new Pedido("P001");
        assertDoesNotThrow(pedido::pagar);
    }

    @Test
    void pedidoPendienteNoPuedePrepararse() {
        Pedido pedido = new Pedido("P002");
        assertThrows(TransicionInvalidaException.class, pedido::preparar);
    }
}

