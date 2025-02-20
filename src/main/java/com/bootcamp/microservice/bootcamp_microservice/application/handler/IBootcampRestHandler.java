package com.bootcamp.microservice.bootcamp_microservice.application.handler;

import com.bootcamp.microservice.bootcamp_microservice.application.dto.BootcampRequest;
import com.bootcamp.microservice.bootcamp_microservice.domain.model.BootcampModel;
import reactor.core.publisher.Mono;

public interface IBootcampRestHandler {
    Mono<Void> createBootcamp(BootcampRequest bootcampRequest);
}
