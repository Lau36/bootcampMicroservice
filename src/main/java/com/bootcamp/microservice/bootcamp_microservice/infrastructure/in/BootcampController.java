package com.bootcamp.microservice.bootcamp_microservice.infrastructure.in;

import com.bootcamp.microservice.bootcamp_microservice.application.dto.BootcampRequest;
import com.bootcamp.microservice.bootcamp_microservice.application.handler.IBootcampRestHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static com.bootcamp.microservice.bootcamp_microservice.infrastructure.utils.constans.InfraConstans.BOOTCAMP_PATH;

@RestController()
@AllArgsConstructor
@RequestMapping(BOOTCAMP_PATH)
public class BootcampController {
    private final IBootcampRestHandler bootcampRestHandler;

    @PostMapping
    public Mono<ResponseEntity<Void>> createBootcamp(@RequestBody BootcampRequest bootcampRequest) {
        return bootcampRestHandler.createBootcamp(bootcampRequest).then(Mono.just(ResponseEntity.status(HttpStatus.CREATED).build()));
    }
}
