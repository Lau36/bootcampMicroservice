package com.bootcamp.microservice.bootcamp_microservice.infrastructure.out.entity;

import com.bootcamp.microservice.bootcamp_microservice.domain.utils.Capacity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "bootcamp")
@Getter
@Setter
@AllArgsConstructor
public class BootcampEntity {

    @Id
    private String id;
    private String name;
    private String description;
    private List<Capacity> capacities;
    private Integer capacitiesCount;
}

