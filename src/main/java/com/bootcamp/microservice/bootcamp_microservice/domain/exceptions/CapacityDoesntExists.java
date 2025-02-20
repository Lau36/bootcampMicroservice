package com.bootcamp.microservice.bootcamp_microservice.domain.exceptions;

public class CapacityDoesntExists extends RuntimeException {
    public CapacityDoesntExists(String message) {
        super(message);
    }
}
