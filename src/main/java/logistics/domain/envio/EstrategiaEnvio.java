package logistics.domain.envio;

import logistics.domain.Pedido;
import java.math.BigDecimal;

public interface EstrategiaEnvio {
    BigDecimal calcularTarifa(Pedido pedido);
}

