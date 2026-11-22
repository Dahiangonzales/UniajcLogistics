package co.edu.uniajc.logistics.domain.envio;

import co.edu.uniajc.logistics.domain.Pedido;
import java.math.BigDecimal;

public class RetiroEnPunto implements EstrategiaEnvio {
    public BigDecimal calcularTarifa(Pedido pedido) {
        return BigDecimal.ZERO;
    }
}
