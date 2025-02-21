package com.bootcamp.microservice.bootcamp_microservice.infrastructure.out.adapter;

import com.bootcamp.microservice.bootcamp_microservice.domain.ports.out.ICapacityClientPort;
import com.bootcamp.microservice.bootcamp_microservice.domain.utils.CapacitiesId;
import com.bootcamp.microservice.bootcamp_microservice.domain.utils.CapacityWithTechnologies;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.bootcamp.microservice.bootcamp_microservice.infrastructure.utils.constans.InfraConstans.*;

@Component
@AllArgsConstructor
public class CapacityClientAdapter implements ICapacityClientPort {
    private final WebClient webClient;


    @Override
    public Flux<CapacityWithTechnologies> getCapacity(CapacitiesId capacitiesId) {
        return webClient.post()
                .uri(LIST_CAPACITIES_PATH)
                .bodyValue(capacitiesId)
                .retrieve()
                .bodyToFlux(CapacityWithTechnologies.class);
    }

    @Override
    public Mono<Boolean> existsCapacities(CapacitiesId capacitiesId) {
        return webClient.post()
                .uri(EXISTS_CAPACITIES_PATH)
                .bodyValue(capacitiesId)
                .retrieve()
                .bodyToMono(Boolean.class);
    }
}
