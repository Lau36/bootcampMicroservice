package com.bootcamp.microservice.bootcamp_microservice.domain.exceptions;

public class DoesntHaveMinimunCapacitiesException extends RuntimeException {
    public DoesntHaveMinimunCapacitiesException(String message) {
        super(message);
    }
}
