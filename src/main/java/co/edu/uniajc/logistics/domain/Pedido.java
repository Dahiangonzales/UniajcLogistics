package co.edu.uniajc.logistics.domain;

import co.edu.uniajc.logistics.domain.envio.EstrategiaEnvio;
import co.edu.uniajc.logistics.observadores.PedidoObserver;
import co.edu.uniajc.logistics.domain.states.PendienteState;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final String id;
private EstadoPedidoState estado = new PendienteState();
    private EstrategiaEnvio estrategiaEnvio;
    private BigDecimal total = BigDecimal.ZERO;
    private final List<PedidoObserver> observadores = new ArrayList<>();

    public Pedido(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public EstadoPedidoState getEstado() {
        return estado;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void cambiarEstado(EstadoPedidoState nuevoEstado) {
        EstadoPedidoState anterior = this.estado;
        this.estado = nuevoEstado;
        notificar(anterior, nuevoEstado);
    }

    public void cambiarEstrategiaEnvio(EstrategiaEnvio estrategia) {
        this.estrategiaEnvio = estrategia;
    }

    public BigDecimal calcularEnvio() {
        return estrategiaEnvio.calcularTarifa(this);
    }

    public void suscribir(PedidoObserver observador) {
        observadores.add(observador);
    }

    private void notificar(EstadoPedidoState anterior, EstadoPedidoState nuevo) {
        for (PedidoObserver observador : observadores) {
            observador.actualizar(this, anterior, nuevo);
        }
    }

    public void pagar() {
        estado.pagar(this);
    }

    public void preparar() {
        estado.preparar(this);
    }

    public void enviar() {
        estado.enviar(this);
    }

    public void entregar() {
        estado.entregar(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }
}
