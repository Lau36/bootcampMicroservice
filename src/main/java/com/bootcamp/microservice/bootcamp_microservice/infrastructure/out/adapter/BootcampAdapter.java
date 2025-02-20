package com.bootcamp.microservice.bootcamp_microservice.infrastructure.out.adapter;

import com.bootcamp.microservice.bootcamp_microservice.domain.model.Bootcamp;
import com.bootcamp.microservice.bootcamp_microservice.domain.ports.out.IBootcampPersistencePort;
import com.bootcamp.microservice.bootcamp_microservice.domain.ports.out.ICapacityClientPort;
import com.bootcamp.microservice.bootcamp_microservice.infrastructure.out.entity.BootcampEntity;
import com.bootcamp.microservice.bootcamp_microservice.infrastructure.out.repository.IBootcampRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class BootcampAdapter implements IBootcampPersistencePort {

    private final IBootcampRepository bootcampRepository;

    @Override
    public Mono<Void> saveBootcamp(Bootcamp bootcamp) {
        BootcampEntity entity = new BootcampEntity(
                " ",
                bootcamp.getName(),
                bootcamp.getDescription(),
                bootcamp.getcapacities(),
                bootcamp.getcapacities().size()
        );
        return bootcampRepository.save(entity).then();
    }
}
