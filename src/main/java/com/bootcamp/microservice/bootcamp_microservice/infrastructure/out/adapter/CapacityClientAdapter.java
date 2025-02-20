package com.bootcamp.microservice.bootcamp_microservice.infrastructure.out.adapter;

import com.bootcamp.microservice.bootcamp_microservice.domain.ports.out.ICapacityClientPort;
import com.bootcamp.microservice.bootcamp_microservice.domain.utils.Capacity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

import static com.bootcamp.microservice.bootcamp_microservice.infrastructure.utils.constans.InfraConstans.CAPACITIES;
import static com.bootcamp.microservice.bootcamp_microservice.infrastructure.utils.constans.InfraConstans.LIST_CAPACITIES_PATH;

@Component
@AllArgsConstructor
public class CapacityClientAdapter implements ICapacityClientPort {
    private final WebClient webClient;

    @Override
    public Flux<Capacity> listCapacities(List<Long> capacities) {
        return webClient.get()
                .uri(
                        uriBuilder -> uriBuilder
                                .path(LIST_CAPACITIES_PATH)
                                .queryParam(CAPACITIES,capacities)
                                .build()
                )
                .retrieve()
                .bodyToFlux(Capacity.class);
    }
}
