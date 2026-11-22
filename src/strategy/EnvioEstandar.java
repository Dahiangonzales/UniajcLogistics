package strategy;

public class EnvioEstandar implements EstrategiaEnvio {
    private static final double TARIFA_BASE = 10.0;
    private static final double COSTO_POR_KG = 2.5;

    @Override
    public double calcularCosto(double subtotal, double pesoKg) {
        return TARIFA_BASE + (pesoKg * COSTO_POR_KG);
    }
}