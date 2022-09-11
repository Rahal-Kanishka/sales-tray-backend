package com.salestray.salestraybackend.exceptions;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String errorMessage){
        super("Requested Object is not found: " + errorMessage);
    }
}
