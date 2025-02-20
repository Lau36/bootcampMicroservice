package com.bootcamp.microservice.bootcamp_microservice.domain.ports.out;

import com.bootcamp.microservice.bootcamp_microservice.domain.utils.Capacity;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ICapacityClientPort {
    Flux<Capacity> listCapacities(List<Long> capacities);
}
