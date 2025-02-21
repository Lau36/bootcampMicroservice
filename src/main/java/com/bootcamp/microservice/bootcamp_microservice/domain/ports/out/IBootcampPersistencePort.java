package com.bootcamp.microservice.bootcamp_microservice.domain.ports.out;

import com.bootcamp.microservice.bootcamp_microservice.domain.model.BootcampWithCapacitiesModel;
import com.bootcamp.microservice.bootcamp_microservice.domain.utils.Paginated;
import com.bootcamp.microservice.bootcamp_microservice.domain.utils.Pagination;
import reactor.core.publisher.Mono;

public interface IBootcampPersistencePort{
    Mono<Void> saveBootcamp(BootcampWithCapacitiesModel bootcampWithCapacitiesModel);
    Mono<Paginated> getAllBootcampsWithPagination(Pagination pagination);
}
