package com.bootcamp.microservice.bootcamp_microservice.domain;

import com.bootcamp.microservice.bootcamp_microservice.domain.exceptions.CapacitiesNumberExceededException;
import com.bootcamp.microservice.bootcamp_microservice.domain.exceptions.CapacityDoesntExists;
import com.bootcamp.microservice.bootcamp_microservice.domain.exceptions.DoesntHaveMinimunCapacitiesException;
import com.bootcamp.microservice.bootcamp_microservice.domain.model.BootcampModel;
import com.bootcamp.microservice.bootcamp_microservice.domain.model.BootcampWithCapacitiesModel;
import com.bootcamp.microservice.bootcamp_microservice.domain.ports.out.IBootcampPersistencePort;
import com.bootcamp.microservice.bootcamp_microservice.domain.ports.out.ICapacityClientPort;
import com.bootcamp.microservice.bootcamp_microservice.domain.useCase.BootcampUseCase;
import com.bootcamp.microservice.bootcamp_microservice.domain.utils.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BootcampUseCaseTest {

    @Mock
    private ICapacityClientPort capacityClientPort;

    @Mock
    private IBootcampPersistencePort bootcampPersistencePort;

    @InjectMocks
    private BootcampUseCase bootcampUseCase;

    private static BootcampModel bootcampModel;


    @BeforeEach
    void setUp(){
        bootcampModel = new BootcampModel(
                1L,
                "Test bootcamp",
                "Desc",
                List.of(1L, 2L, 3L)
                );
    }

    @Test
    void createBootcamp_Success() {
        
        List<Technology> technologies = List.of(new Technology(1L, "Java"), new Technology(2L, "Spring Boot"));
        List<Capacity> capacities = List.of(
                new Capacity(1L, "Backend", technologies),
                new Capacity(2L, "Frontend", technologies)
        );

        Mockito.when(capacityClientPort.existsCapacities(ArgumentMatchers.any(CapacitiesId.class))).thenReturn(Mono.just(true));
        Mockito.when(capacityClientPort.getCapacity(ArgumentMatchers.any(CapacitiesId.class))).thenReturn(Flux.fromIterable(capacities));
        Mockito.when(bootcampPersistencePort.saveBootcamp(ArgumentMatchers.any(BootcampWithCapacitiesModel.class)))
                .thenReturn(Mono.empty());

        Mono<Void> result = bootcampUseCase.createBootcamp(bootcampModel);

        StepVerifier.create(result)
                .verifyComplete();

        verify(capacityClientPort, times(1)).existsCapacities(ArgumentMatchers.any(CapacitiesId.class));
        verify(capacityClientPort, times(1)).getCapacity(ArgumentMatchers.any(CapacitiesId.class));
        verify(bootcampPersistencePort, times(1)).saveBootcamp(ArgumentMatchers.any(BootcampWithCapacitiesModel.class));
    }


    @Test
    void getAllBootcampsWithPagination(){
        Pagination pagination = new Pagination(0, 2, "name", SortDirection.ASC);
        List<Technology> technologies = List.of(new Technology(1L, "Technology 1"));
        List<Capacity> capacities = List.of(new Capacity(1L, "capacidad 1", technologies));
        BootcampWithCapacitiesModel model = new BootcampWithCapacitiesModel("id", "bootcamp 1", "descriptioon 1", capacities);
        Paginated paginated = new Paginated(0, 1, 1, List.of(model));

        Mockito.when(bootcampPersistencePort.getAllBootcampsWithPagination(pagination)).thenReturn(Mono.just(paginated));

        Mono<Paginated> result = bootcampUseCase.getAllBootcampsWithPagination(pagination);

        StepVerifier.create(result)
                .expectNext(paginated)
                .verifyComplete();

    }

    @Test
    void createBootcamp_FailsWhenCapacitiesDoNotExist() {

        Mockito.when(capacityClientPort.existsCapacities(ArgumentMatchers.any())).thenReturn(Mono.just(false));

        Mono<Void> result = bootcampUseCase.createBootcamp(bootcampModel);

        StepVerifier.create(result)
                .expectError(CapacityDoesntExists.class)
                .verify();
    }

    @Test
    void validationsBootcamp_Success() {

        StepVerifier.create(bootcampUseCase.validationsBootcamp(bootcampModel)).verifyComplete();
    }

    @Test
    void validationsCapacity_FailsWhenTooFewTechnologies() {
        BootcampModel bootcampModel = new BootcampModel(1L, "Test bootcamp", "Desc", List.of());
        StepVerifier.create(bootcampUseCase.validationsBootcamp(bootcampModel))
                .expectError(DoesntHaveMinimunCapacitiesException.class)
                .verify();
    }

    @Test
    void validationsCapacity_FailsWhenTooManyTechnologies() {
        List<Long> capacitiesId = Arrays.asList(1L, 2L, 3L, 4L, 5L);

        BootcampModel bootcampModel = new BootcampModel(1L, "Test bootcamp", "Desc", capacitiesId);

        StepVerifier.create(bootcampUseCase.validationsBootcamp(bootcampModel))
                .expectError(CapacitiesNumberExceededException.class)
                .verify();
    }

    

}
