package com.bootcamp.microservice.bootcamp_microservice.domain.ports.out;

import com.bootcamp.microservice.bootcamp_microservice.domain.utils.CapacitiesId;
import com.bootcamp.microservice.bootcamp_microservice.domain.utils.CapacityWithTechnologies;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ICapacityClientPort {
    Flux<CapacityWithTechnologies> getCapacity(CapacitiesId capacitiesId);
    Mono<Boolean> existsCapacities(CapacitiesId capacitiesId);
}
