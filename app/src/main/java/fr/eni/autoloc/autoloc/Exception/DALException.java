package fr.eni.autoloc.autoloc.Exception;

public class DALException extends Exception {
    public DALException() {
    }

    public DALException(String message) {
        super(message);
    }

    public DALException(String message, Throwable cause) {
        super(message, cause);
    }
}
