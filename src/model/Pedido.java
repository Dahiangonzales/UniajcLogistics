package model;

import observer.EventoPedido;
import observer.PedidoObservador;
import state.EstadoPedido;
import state.PendienteEstado;
import strategy.EstrategiaEnvio;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final String id;
    private final double subtotal;
    private final double pesoKg;
    private final boolean clienteConHistorial;
    private final boolean zonaConCobertura;
    private final int stockDisponible;
    private final int cantidadSolicitada;
    private double descuento;
    private String direccionEntrega;

    private EstadoPedido estado;
    private EstrategiaEnvio estrategiaEnvio;
    private final List<PedidoObservador> observadores = new ArrayList<>();

    public Pedido(String id, double subtotal, double pesoKg, int stockDisponible,
                  int cantidadSolicitada, boolean clienteConHistorial,
                  boolean zonaConCobertura, String direccionEntrega,
                  EstrategiaEnvio estrategiaEnvio) {
        this.id = id;
        this.subtotal = subtotal;
        this.pesoKg = pesoKg;
        this.stockDisponible = stockDisponible;
        this.cantidadSolicitada = cantidadSolicitada;
        this.clienteConHistorial = clienteConHistorial;
        this.zonaConCobertura = zonaConCobertura;
        this.direccionEntrega = direccionEntrega;
        this.estrategiaEnvio = estrategiaEnvio;
        this.estado = new PendienteEstado();
    }

    public void cambiarEstado(EstadoPedido nuevoEstado) {
        String estadoAnterior = this.estado.nombre();
        this.estado = nuevoEstado;
        notificar(new EventoPedido(id, estadoAnterior, nuevoEstado.nombre()));
    }

    public void setEstrategiaEnvio(EstrategiaEnvio estrategiaEnvio) {
        this.estrategiaEnvio = estrategiaEnvio;
    }

    public double calcularTotal() {
        double baseConDescuento = Math.max(0, subtotal - descuento);
        return baseConDescuento + estrategiaEnvio.calcularCosto(subtotal, pesoKg);
    }

    public void suscribir(PedidoObservador observador) {
        observadores.add(observador);
    }

    private void notificar(EventoPedido evento) {
        for (PedidoObservador obs : observadores) {
            obs.actualizar(evento);
        }
    }

    public void pagar() { estado.pagar(this); }
    public void preparar() { estado.preparar(this); }
    public void enviar() { estado.enviar(this); }
    public void entregar() { estado.entregar(this); }
    public void cancelar() { estado.cancelar(this); }

    public String getId() { return id; }
    public double getSubtotal() { return subtotal; }
    public double getPesoKg() { return pesoKg; }
    public boolean isClienteConHistorial() { return clienteConHistorial; }
    public boolean isZonaConCobertura() { return zonaConCobertura; }
    public int getStockDisponible() { return stockDisponible; }
    public int getCantidadSolicitada() { return cantidadSolicitada; }
    public String getEstadoNombre() { return estado.nombre(); }
    public void setDescuento(double descuento) { this.descuento = descuento; }
    public double getDescuento() { return descuento; }
    public void setDireccionEntrega(String direccionEntrega) { this.direccionEntrega = direccionEntrega; }
    public String getDireccionEntrega() { return direccionEntrega; }
}