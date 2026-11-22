package co.edu.uniajc.logistics;

import co.edu.uniajc.logistics.domain.Pedido;
import co.edu.uniajc.logistics.domain.envio.EnvioEstandar;
import co.edu.uniajc.logistics.domain.envio.EnvioExpress;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstrategiaEnvioTest {
    @Test
    void puedeCambiarEstrategiaEnTiempoEjecucion() {
        Pedido pedido = new Pedido("P003");
        pedido.cambiarEstrategiaEnvio(new EnvioEstandar());
        pedido.cambiarEstrategiaEnvio(new EnvioExpress());
        assertEquals(new java.math.BigDecimal("18000"), pedido.calcularEnvio());
    }
}
