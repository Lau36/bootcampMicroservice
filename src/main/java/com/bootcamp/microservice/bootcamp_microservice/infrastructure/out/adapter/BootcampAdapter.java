package com.bootcamp.microservice.bootcamp_microservice.infrastructure.out.adapter;

import com.bootcamp.microservice.bootcamp_microservice.domain.model.BootcampWithCapacitiesModel;
import com.bootcamp.microservice.bootcamp_microservice.domain.ports.out.IBootcampPersistencePort;
import com.bootcamp.microservice.bootcamp_microservice.domain.utils.Paginated;
import com.bootcamp.microservice.bootcamp_microservice.domain.utils.Pagination;
import com.bootcamp.microservice.bootcamp_microservice.infrastructure.out.entity.BootcampEntity;
import com.bootcamp.microservice.bootcamp_microservice.infrastructure.out.repository.IBootcampRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import reactor.core.publisher.Mono;

import java.util.List;

@AllArgsConstructor
public class BootcampAdapter implements IBootcampPersistencePort {

    private final IBootcampRepository bootcampRepository;

    @Override
    public Mono<Void> saveBootcamp(BootcampWithCapacitiesModel bootcampWithCapacitiesModel) {
        BootcampEntity entity = new BootcampEntity(
                null,
                bootcampWithCapacitiesModel.getName(),
                bootcampWithCapacitiesModel.getDescription(),
                bootcampWithCapacitiesModel.getcapacities(),
                bootcampWithCapacitiesModel.getcapacities().size()
        );
        return bootcampRepository.save(entity).then();
    }

    @Override
    public Mono<Paginated> getAllBootcampsWithPagination(Pagination pagination) {
        Sort sort = Sort.by(Sort.Direction.fromString(pagination.getSortDirection().name()), pagination.getSort());
        PageRequest pageable = PageRequest.of(pagination.getPage(), pagination.getSize(), sort);

        Mono<List<BootcampWithCapacitiesModel>> bootcamps =
                bootcampRepository.findAllBy(pageable)
                        .map(this::toBootcamp)
                        .collectList();

        Mono<Long> totalElements = bootcampRepository.count()
                .defaultIfEmpty(0L);

        return Mono.zip(bootcamps, totalElements).map(
                tuple -> {
                    Long totalElementsValue = tuple.getT2();
                    int totalPages = (int) Math.ceil((double) totalElementsValue / pagination.getSize());

                    return new Paginated(
                            pagination.getPage(),
                            totalPages,
                            totalElementsValue,
                            tuple.getT1()
                    );
                });
    }

    public BootcampWithCapacitiesModel toBootcamp(BootcampEntity bootcampEntity) {
        return new BootcampWithCapacitiesModel(bootcampEntity.getId(), bootcampEntity.getName(), bootcampEntity.getDescription(), bootcampEntity.getCapacities());
    }
}
