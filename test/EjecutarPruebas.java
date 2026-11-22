package test;

import chain.CoberturaValidador;
import chain.FraudeValidador;
import chain.StockValidador;
import chain.ValidadorPedido;
import model.Pedido;
import observer.AuditoriaLogger;
import strategy.EnvioEstandar;
import strategy.EnvioExpress;
import strategy.EstrategiaEnvio;

public class EjecutarPruebas {
    private static int exitosas = 0;
    private static int fallidas = 0;

    public static void main(String[] args) {
        pruebaRechazoPorStock();
        pruebaRechazoPorFraude();
        pruebaRechazoPorCobertura();
        pruebaPrepararSinPagarLanzaError();
        pruebaCancelarPedidoEnviadoLanzaError();
        pruebaEntregadoEsTerminalNoAdmiteCambios();
        pruebaCambioDinamicoEstrategiaEnvio();
        pruebaNuevaEstrategiaCumpleOCP();

        System.out.printf("Resumen: %d exitosas, %d fallidas%n", exitosas, fallidas);
        if (fallidas > 0) {
            throw new AssertionError("Hay pruebas unitarias fallidas.");
        }
    }

    private static ValidadorPedido cadenaCompleta() {
        ValidadorPedido stock = new StockValidador();
        stock.enlazar(new FraudeValidador()).enlazar(new CoberturaValidador());
        return stock;
    }

    private static Pedido pedidoBase() {
        return new Pedido("PED-1", 500.0, 2.0, 10, 2,
                true, true, "Calle 10 # 5-20", new EnvioEstandar());
    }

    // 1. Fallo en cadena de validación: stock
    private static void pruebaRechazoPorStock() {
        Pedido p = new Pedido("P-1", 100.0, 1.0, 1, 5,
                true, true, "Dir", new EnvioEstandar());
        var res = cadenaCompleta().validar(p);
        afirmar(!res.esValido(), "Debe rechazar por falta de stock");
    }

    // 2. Fallo en cadena de validación: fraude
    private static void pruebaRechazoPorFraude() {
        Pedido p = new Pedido("P-2", 5000.0, 1.0, 10, 1,
                false, true, "Dir", new EnvioEstandar());
        var res = cadenaCompleta().validar(p);
        afirmar(!res.esValido(), "Debe rechazar por monto alto sin historial");
    }

    // 3. Fallo en cadena de validación: cobertura
    private static void pruebaRechazoPorCobertura() {
        Pedido p = new Pedido("P-3", 200.0, 1.0, 10, 1,
                true, false, "Dir", new EnvioEstandar());
        var res = cadenaCompleta().validar(p);
        afirmar(!res.esValido(), "Debe rechazar por falta de cobertura");
    }

    // 4. Transición inválida: pasar a EnPreparacion sin estar Pagado
    private static void pruebaPrepararSinPagarLanzaError() {
        Pedido p = pedidoBase();
        afirmarLanzaExcepcion(p::preparar, "No debe pasar a EnPreparacion sin Pagado");
    }

    // 5. Transición inválida: cancelar un pedido ya Enviado
    private static void pruebaCancelarPedidoEnviadoLanzaError() {
        Pedido p = pedidoBase();
        p.pagar();
        p.preparar();
        p.enviar();
        afirmarLanzaExcepcion(p::cancelar, "No debe permitir cancelar un pedido Enviado");
    }

    // 6. Estado terminal: Entregado no admite modificaciones
    private static void pruebaEntregadoEsTerminalNoAdmiteCambios() {
        Pedido p = pedidoBase();
        AuditoriaLogger logger = new AuditoriaLogger();
        p.suscribir(logger);
        p.pagar();
        p.preparar();
        p.enviar();
        p.entregar();
        int eventosAlEntregar = logger.getHistorial().size();

        afirmarLanzaExcepcion(p::cancelar, "Entregado no debe permitir cancelar");
        afirmar("Entregado".equals(p.getEstadoNombre()), "Debe mantenerse en Entregado");
        afirmar(logger.getHistorial().size() == eventosAlEntregar, "No debe emitir nuevos eventos");
    }

    // 7. Cambio dinámico de estrategia de envío y recálculo del total
    private static void pruebaCambioDinamicoEstrategiaEnvio() {
        Pedido p = pedidoBase(); // subtotal 500, peso 2 -> Estándar: 10 + (2 * 2.5) = 15 -> total 515
        afirmar(Math.abs(p.calcularTotal() - 515.0) < 0.001, "Total con Envío Estándar debe ser 515.0");

        p.setEstrategiaEnvio(new EnvioExpress()); // Express: (10 * 1.8) + 15 = 33 -> total 533
        afirmar(Math.abs(p.calcularTotal() - 533.0) < 0.001, "Total con Envío Express debe ser 533.0");
    }

    // 8. Cumplimiento de OCP: nueva estrategia sin modificar clases existentes
    private static void pruebaNuevaEstrategiaCumpleOCP() {
        EstrategiaEnvio retiroEnPunto = (subtotal, pesoKg) -> 0.0;
        Pedido p = pedidoBase();
        p.setEstrategiaEnvio(retiroEnPunto);
        afirmar(Math.abs(p.calcularTotal() - 500.0) < 0.001, "Nueva estrategia sin tocar clases existentes");
    }

    private static void afirmar(boolean condicion, String mensaje) {
        if (condicion) {
            exitosas++;
        } else {
            fallidas++;
            System.err.println("FALLO: " + mensaje);
        }
    }

    private static void afirmarLanzaExcepcion(Runnable accion, String mensaje) {
        try {
            accion.run();
            fallidas++;
            System.err.println("FALLO (no lanzó excepción): " + mensaje);
        } catch (RuntimeException ex) {
            exitosas++;
        }
    }
}