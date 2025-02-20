package com.bootcamp.microservice.bootcamp_microservice.infrastructure.out.repository;

import com.bootcamp.microservice.bootcamp_microservice.infrastructure.out.entity.BootcampEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface IBootcampRepository extends ReactiveMongoRepository<BootcampEntity, String> {

    Flux<BootcampEntity> findAllBy(PageRequest pageable);
}