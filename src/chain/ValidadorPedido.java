package chain;

import model.Pedido;

public abstract class ValidadorPedido {
    private ValidadorPedido siguiente;

    public ValidadorPedido enlazar(ValidadorPedido siguiente) {
        this.siguiente = siguiente;
        return siguiente;
    }

    public ResultadoValidacion validar(Pedido pedido) {
        ResultadoValidacion actual = comprobar(pedido);
        if (!actual.esValido()) {
            return actual;
        }
        return siguiente != null ? siguiente.validar(pedido) : ResultadoValidacion.ok();
    }

    protected abstract ResultadoValidacion comprobar(Pedido pedido);

    public record ResultadoValidacion(boolean esValido, String motivo) {
        public static ResultadoValidacion ok() { return new ResultadoValidacion(true, "OK"); }
        public static ResultadoValidacion error(String motivo) { return new ResultadoValidacion(false, motivo); }
    }
}