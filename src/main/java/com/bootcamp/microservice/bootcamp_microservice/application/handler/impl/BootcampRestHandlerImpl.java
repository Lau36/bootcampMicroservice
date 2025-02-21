package com.bootcamp.microservice.bootcamp_microservice.application.handler.impl;

import com.bootcamp.microservice.bootcamp_microservice.application.dto.request.BootcampRequest;
import com.bootcamp.microservice.bootcamp_microservice.application.handler.IBootcampRestHandler;
import com.bootcamp.microservice.bootcamp_microservice.domain.model.BootcampModel;
import com.bootcamp.microservice.bootcamp_microservice.domain.ports.in.IBootcampServicePort;
import com.bootcamp.microservice.bootcamp_microservice.domain.utils.Paginated;
import com.bootcamp.microservice.bootcamp_microservice.domain.utils.Pagination;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class BootcampRestHandlerImpl implements IBootcampRestHandler {

    private IBootcampServicePort bootcampServicePort;


    @Override
    public Mono<Void> createBootcamp(BootcampRequest bootcampRequest) {
        BootcampModel model = new BootcampModel(
                bootcampRequest.getId(),
                bootcampRequest.getName(),
                bootcampRequest.getDescription(),
                bootcampRequest.getCapacitiesId()
        );
        return bootcampServicePort.createBootcamp(model);
    }

    @Override
    public Mono<Paginated> getAllBootcampsWithPagination(Pagination pagination) {
        return bootcampServicePort.getAllBootcampsWithPagination(pagination);
    }
}
