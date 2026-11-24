package logistics.validacion;

import logistics.domain.Pedido;

import java.math.BigDecimal;

public class ValidadorFraude extends ValidadorPedido {
    private final BigDecimal umbralSospechoso;

    public ValidadorFraude(BigDecimal umbralSospechoso) {
        this.umbralSospechoso = umbralSospechoso;
    }

    @Override
    protected boolean esValido(Pedido pedido) {
        return pedido.getTotal().compareTo(umbralSospechoso) <= 0;
    }

    @Override
    protected String motivoRechazo(Pedido pedido) {
        return "Posible fraude: el monto " + pedido.getTotal()
                + " supera el umbral permitido de " + umbralSospechoso;
    }
}