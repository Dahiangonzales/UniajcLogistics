package strategy;

public class EnvioInternacional implements EstrategiaEnvio {
    private final double tarifaZona;
    private final double recargoArancelario;

    public EnvioInternacional(double tarifaZona, double recargoArancelario) {
        this.tarifaZona = tarifaZona;
        this.recargoArancelario = recargoArancelario;
    }

    @Override
    public double calcularCosto(double subtotal, double pesoKg) {
        return tarifaZona + recargoArancelario;
    }
}