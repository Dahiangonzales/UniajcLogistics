package strategy;

public class EnvioExpress implements EstrategiaEnvio {
    private static final double TARIFA_BASE = 10.0;
    private static final double PRIORIDAD_DESPACHO = 15.0;

    @Override
    public double calcularCosto(double subtotal, double pesoKg) {
        return (TARIFA_BASE * 1.8) + PRIORIDAD_DESPACHO;
    }
}
