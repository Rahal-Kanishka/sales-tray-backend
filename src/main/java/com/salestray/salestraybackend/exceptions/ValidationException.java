package com.salestray.salestraybackend.exceptions;

/**
 * Extending RuntimeException so this exception don't have to be checked
 */
public class ValidationException extends RuntimeException {

    public ValidationException(String errorMessage) {
        super("Validation failed: " + errorMessage);
    }
}
