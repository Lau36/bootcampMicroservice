package com.bootcamp.microservice.bootcamp_microservice.application.handler;

import com.bootcamp.microservice.bootcamp_microservice.application.dto.request.BootcampRequest;
import com.bootcamp.microservice.bootcamp_microservice.domain.utils.Paginated;
import com.bootcamp.microservice.bootcamp_microservice.domain.utils.Pagination;
import reactor.core.publisher.Mono;

public interface IBootcampRestHandler {
    Mono<Void> createBootcamp(BootcampRequest bootcampRequest);
    Mono<Paginated> getAllBootcampsWithPagination(Pagination pagination);
}
