package logistics;

import logistics.domain.Pedido;
import logistics.validacion.ValidadorCobertura;
import logistics.validacion.ValidadorFraude;
import logistics.validacion.ValidadorStock;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ValidacionPedidoTest {

    @Test
    void pedidoValidoPasaLaCadena() {
        Pedido pedido = new Pedido("P010");
        pedido.setTotal(new BigDecimal("5000"));
        pedido.setDestino("Cali");

        ValidadorStock stock = new ValidadorStock(true);
        ValidadorFraude fraude = new ValidadorFraude(new BigDecimal("10000"));
        ValidadorCobertura cobertura = new ValidadorCobertura(Set.of("Cali", "Bogota"));

        stock.conectarCon(fraude).conectarCon(cobertura);

        assertDoesNotThrow(() -> stock.validar(pedido));
    }

    @Test
    void pedidoSinStockEsRechazado() {
        Pedido pedido = new Pedido("P011");
        pedido.setStockDisponible(false);

        ValidadorStock stock = new ValidadorStock(false);

        IllegalArgumentException excepcion = assertThrows(
                IllegalArgumentException.class,
                () -> stock.validar(pedido)
        );

        assertTrue(excepcion.getMessage().contains("Stock insuficiente"));
    }

    @Test
    void pedidoConMontoSospechosoEsRechazado() {
        Pedido pedido = new Pedido("P012");
        pedido.setTotal(new BigDecimal("20000"));

        ValidadorFraude fraude = new ValidadorFraude(new BigDecimal("10000"));

        IllegalArgumentException excepcion = assertThrows(
                IllegalArgumentException.class,
                () -> fraude.validar(pedido)
        );

        assertTrue(excepcion.getMessage().contains("Posible fraude"));
    }

    @Test
    void pedidoSinCoberturaEsRechazado() {
        Pedido pedido = new Pedido("P013");
        pedido.setDestino("Pasto");

        ValidadorCobertura cobertura = new ValidadorCobertura(Set.of("Cali", "Bogota"));

        IllegalArgumentException excepcion = assertThrows(
                IllegalArgumentException.class,
                () -> cobertura.validar(pedido)
        );

        assertTrue(excepcion.getMessage().contains("Zona sin cobertura"));
    }
}