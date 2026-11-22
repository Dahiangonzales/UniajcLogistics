package observer;

import java.time.Instant;

public record EventoPedido(String pedidoId, String estadoAnterior, String estadoNuevo, Instant marcaTiempo) {
    public EventoPedido(String pedidoId, String estadoAnterior, String estadoNuevo) {
        this(pedidoId, estadoAnterior, estadoNuevo, Instant.now());
    }
}