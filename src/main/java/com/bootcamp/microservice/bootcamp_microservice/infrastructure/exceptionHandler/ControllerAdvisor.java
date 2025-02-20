package com.bootcamp.microservice.bootcamp_microservice.infrastructure.exceptionHandler;

import com.bootcamp.microservice.bootcamp_microservice.domain.exceptions.CapacitiesNumberExceededException;
import com.bootcamp.microservice.bootcamp_microservice.domain.exceptions.CapacityDoesntExists;
import com.bootcamp.microservice.bootcamp_microservice.domain.exceptions.DoesntHaveMinimunCapacitiesException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class ControllerAdvisor {
    

    @ExceptionHandler(DoesntHaveMinimunCapacitiesException.class)
    public Mono<ResponseEntity<String>> handleDoesntHaveMinimunCapacities(DoesntHaveMinimunCapacitiesException ex) {
        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage()));
    }

    @ExceptionHandler(CapacityDoesntExists.class)
    public Mono<ResponseEntity<String>> handleCapacitiesNotFoud(CapacityDoesntExists ex) {
        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage()));
    }

    @ExceptionHandler(CapacitiesNumberExceededException.class)
    public Mono<ResponseEntity<String>> handleCapacitiesNumberExceeded(CapacitiesNumberExceededException ex) {
        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage()));
    }
}
