package logistics.domain.envio;

import logistics.domain.Pedido;
import java.math.BigDecimal;

public class EnvioEstandar implements EstrategiaEnvio {
    public BigDecimal calcularTarifa(Pedido pedido) {
        return new BigDecimal("10000");
    }
}

