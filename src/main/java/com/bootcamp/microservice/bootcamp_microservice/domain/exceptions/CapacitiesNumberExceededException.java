package com.bootcamp.microservice.bootcamp_microservice.domain.exceptions;

public class CapacitiesNumberExceededException extends RuntimeException {
    public CapacitiesNumberExceededException(String message) {
        super(message);
    }
}
