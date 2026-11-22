package co.edu.uniajc.logistics.domain.excepciones;

public class TransicionInvalidaException extends RuntimeException {
    public TransicionInvalidaException(String mensaje) {
        super(mensaje);
    }
}
