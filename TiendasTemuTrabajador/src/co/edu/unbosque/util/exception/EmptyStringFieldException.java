package co.edu.unbosque.util.exception;

public class EmptyStringFieldException extends Exception {
    public EmptyStringFieldException(String message) {
        super(message); // Almacena el mensaje en la excepción
    }
}
