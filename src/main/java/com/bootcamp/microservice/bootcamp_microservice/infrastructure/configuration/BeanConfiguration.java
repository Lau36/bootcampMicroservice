package com.bootcamp.microservice.bootcamp_microservice.infrastructure.configuration;

import com.bootcamp.microservice.bootcamp_microservice.application.handler.IBootcampRestHandler;
import com.bootcamp.microservice.bootcamp_microservice.application.handler.impl.BootcampRestHandlerImpl;
import com.bootcamp.microservice.bootcamp_microservice.domain.ports.in.IBootcampServicePort;
import com.bootcamp.microservice.bootcamp_microservice.domain.ports.out.IBootcampPersistencePort;
import com.bootcamp.microservice.bootcamp_microservice.domain.ports.out.ICapacityClientPort;
import com.bootcamp.microservice.bootcamp_microservice.domain.useCase.BootcampUseCase;
import com.bootcamp.microservice.bootcamp_microservice.infrastructure.out.adapter.BootcampAdapter;
import com.bootcamp.microservice.bootcamp_microservice.infrastructure.out.repository.IBootcampRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IBootcampRepository bootcampRepository;
    private final ICapacityClientPort capacityClientPort;

    @Bean
    public IBootcampServicePort BootcampServicePort() {
        return new BootcampUseCase(BootcampPersistencePort(), capacityClientPort);
    }

    @Bean
    public IBootcampPersistencePort BootcampPersistencePort() {
        return new BootcampAdapter(bootcampRepository);
    }

    @Bean
    public IBootcampRestHandler BootcampRestHandler() {
        return new BootcampRestHandlerImpl(BootcampServicePort());
    }
    
}
