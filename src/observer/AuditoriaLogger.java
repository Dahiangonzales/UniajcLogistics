package observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AuditoriaLogger implements PedidoObservador {
    private final List<EventoPedido> historial = new ArrayList<>();

    @Override
    public void actualizar(EventoPedido evento) {
        historial.add(evento);
    }

    public List<EventoPedido> getHistorial() {
        return Collections.unmodifiableList(historial);
    }
}