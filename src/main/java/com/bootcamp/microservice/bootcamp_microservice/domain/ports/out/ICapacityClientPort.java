package com.bootcamp.microservice.bootcamp_microservice.domain.ports.out;

import com.bootcamp.microservice.bootcamp_microservice.domain.utils.CapacitiesId;
import com.bootcamp.microservice.bootcamp_microservice.domain.utils.Capacity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ICapacityClientPort {
    Flux<Capacity> getCapacity(CapacitiesId capacitiesId);
    Mono<Boolean> existsCapacities(CapacitiesId capacitiesId);
}
