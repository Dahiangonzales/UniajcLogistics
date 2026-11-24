package logistics.domain.envio;

import logistics.domain.Pedido;
import java.math.BigDecimal;

public class RetiroEnPunto implements EstrategiaEnvio {
    public BigDecimal calcularTarifa(Pedido pedido) {
        return BigDecimal.ZERO;
    }
}

