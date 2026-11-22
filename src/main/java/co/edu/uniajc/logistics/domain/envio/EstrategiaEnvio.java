package co.edu.uniajc.logistics.domain.envio;

import co.edu.uniajc.logistics.domain.Pedido;
import java.math.BigDecimal;

public interface EstrategiaEnvio {
    BigDecimal calcularTarifa(Pedido pedido);
}
