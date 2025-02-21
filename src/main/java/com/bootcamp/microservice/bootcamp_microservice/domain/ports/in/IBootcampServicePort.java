package com.bootcamp.microservice.bootcamp_microservice.domain.ports.in;

import com.bootcamp.microservice.bootcamp_microservice.domain.model.BootcampModel;
import com.bootcamp.microservice.bootcamp_microservice.domain.utils.Paginated;
import com.bootcamp.microservice.bootcamp_microservice.domain.utils.Pagination;
import reactor.core.publisher.Mono;

public interface IBootcampServicePort {
    Mono<Void> createBootcamp(BootcampModel bootcampModel);
    Mono<Paginated> getAllBootcampsWithPagination(Pagination pagination);
}
