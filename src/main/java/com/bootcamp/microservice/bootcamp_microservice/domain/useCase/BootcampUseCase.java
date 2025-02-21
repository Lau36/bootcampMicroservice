package com.bootcamp.microservice.bootcamp_microservice.domain.useCase;

import com.bootcamp.microservice.bootcamp_microservice.domain.exceptions.CapacitiesNumberExceededException;
import com.bootcamp.microservice.bootcamp_microservice.domain.exceptions.CapacityDoesntExists;
import com.bootcamp.microservice.bootcamp_microservice.domain.exceptions.DoesntHaveMinimunCapacitiesException;
import com.bootcamp.microservice.bootcamp_microservice.domain.model.BootcampWithCapacitiesModel;
import com.bootcamp.microservice.bootcamp_microservice.domain.model.BootcampModel;
import com.bootcamp.microservice.bootcamp_microservice.domain.ports.in.IBootcampServicePort;
import com.bootcamp.microservice.bootcamp_microservice.domain.ports.out.IBootcampPersistencePort;
import com.bootcamp.microservice.bootcamp_microservice.domain.ports.out.ICapacityClientPort;
import com.bootcamp.microservice.bootcamp_microservice.domain.utils.CapacitiesId;
import com.bootcamp.microservice.bootcamp_microservice.domain.utils.Paginated;
import com.bootcamp.microservice.bootcamp_microservice.domain.utils.Pagination;
import reactor.core.publisher.Mono;

import static com.bootcamp.microservice.bootcamp_microservice.domain.utils.constans.DomainConstans.*;

public class BootcampUseCase implements IBootcampServicePort {

    private final IBootcampPersistencePort bootcampPersistencePort;
    private final ICapacityClientPort capacityClientPort;

    public BootcampUseCase(IBootcampPersistencePort bootcampPersistencePort, ICapacityClientPort capacityClientPort) {
        this.bootcampPersistencePort = bootcampPersistencePort;
        this.capacityClientPort = capacityClientPort;
    }

    @Override
    public Mono<Void> createBootcamp(BootcampModel bootcampModel) {
        CapacitiesId capacitiesId = new CapacitiesId(bootcampModel.getCapacitiesId());

        return validationsBootcamp(bootcampModel)
                .then(capacityClientPort.existsCapacities(capacitiesId))
                .flatMap(exists -> {
                    if (!exists) {
                        return Mono.error(new CapacityDoesntExists(CAPACITIES_DOESNT_EXISTS));
                    }

                    return capacityClientPort.getCapacity(capacitiesId)
                            .collectList()
                            .flatMap(capacities -> {
                                BootcampWithCapacitiesModel bootcampWithCapacitiesModel = new BootcampWithCapacitiesModel(
                                        null,
                                        bootcampModel.getName(),
                                        bootcampModel.getDescription(),
                                        capacities
                                );

                                return bootcampPersistencePort.saveBootcamp(bootcampWithCapacitiesModel).then();
                            });
                });
    }

    @Override
    public Mono<Paginated> getAllBootcampsWithPagination(Pagination pagination) {
        return bootcampPersistencePort.getAllBootcampsWithPagination(pagination);
    }

    public Mono<Void> validationsBootcamp(BootcampModel bootcampModel) {
        if (bootcampModel.getCapacitiesId().size() < MINIMUM_CAPACITIES_ASOCIATED) {
            return Mono.error(new DoesntHaveMinimunCapacitiesException(String.format(DOESNT_HAVE_MINIMUN_CAPACITIES, MINIMUM_CAPACITIES_ASOCIATED)));
        }
        if (bootcampModel.getCapacitiesId().size() > MAXIMUM_CAPACITIES_ASOCIATED) {
            return Mono.error(new CapacitiesNumberExceededException(String.format(CAPACITIES_NUMBER_EXCEEDED, MAXIMUM_CAPACITIES_ASOCIATED)));
        }

        return Mono.empty();
    }
}
