package edu.lev.exceptions.exceptions;

public class CustomException extends RuntimeException {
    public CustomException(String message, final Throwable cause) {
        super(message, cause);
    }
}
