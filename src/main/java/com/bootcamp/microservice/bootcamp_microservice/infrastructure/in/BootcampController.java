package com.bootcamp.microservice.bootcamp_microservice.infrastructure.in;

import com.bootcamp.microservice.bootcamp_microservice.application.dto.request.BootcampRequest;
import com.bootcamp.microservice.bootcamp_microservice.application.handler.IBootcampRestHandler;
import com.bootcamp.microservice.bootcamp_microservice.domain.utils.Paginated;
import com.bootcamp.microservice.bootcamp_microservice.domain.utils.Pagination;
import com.bootcamp.microservice.bootcamp_microservice.domain.utils.SortDirection;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public Mono<Paginated> getBootcampsPaginated(@RequestParam int page,
                                                 @RequestParam int size,
                                                 @RequestParam String sort,
                                                 @RequestParam String sortDirection) {
        Pagination pagination = new Pagination(page, size, sort, SortDirection.valueOf(sortDirection.toUpperCase()));
        return bootcampRestHandler.getAllBootcampsWithPagination(pagination );
    }
}
