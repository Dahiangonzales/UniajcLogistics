package logistics.validacion;

import logistics.domain.Pedido;

import java.util.Set;

public class ValidadorCobertura extends ValidadorPedido {
    private final Set<String> zonasCubiertas;

    public ValidadorCobertura(Set<String> zonasCubiertas) {
        this.zonasCubiertas = zonasCubiertas;
    }

    @Override
    protected boolean esValido(Pedido pedido) {
        return zonasCubiertas.contains(pedido.getDestino());
    }

    @Override
    protected String motivoRechazo(Pedido pedido) {
        return "Zona sin cobertura logistica: " + pedido.getDestino();
    }
}