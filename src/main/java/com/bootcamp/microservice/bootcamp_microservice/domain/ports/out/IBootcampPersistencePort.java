package com.bootcamp.microservice.bootcamp_microservice.domain.ports.out;

import com.bootcamp.microservice.bootcamp_microservice.domain.model.Bootcamp;
import reactor.core.publisher.Mono;

public interface IBootcampPersistencePort{
    Mono<Void> saveBootcamp(Bootcamp bootcamp);
}
