package com.bootcamp.microservice.bootcamp_microservice.domain.ports.in;

import com.bootcamp.microservice.bootcamp_microservice.domain.model.BootcampModel;
import reactor.core.publisher.Mono;

public interface IBootcampServicePort {
    Mono<Void> createBootcamp(BootcampModel bootcampModel);
}
