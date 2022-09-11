package com.salestray.salestraybackend.exceptions;

public class InSufficientResourcesException extends RuntimeException {

    public InSufficientResourcesException() {
        super("Insufficient resources available");
    }

    public InSufficientResourcesException(int requestedNumberOfResources, int availableNUmberOfResources) {
        super("Insufficient resources available, requested: " + requestedNumberOfResources + " available: " + availableNUmberOfResources);
    }
}
