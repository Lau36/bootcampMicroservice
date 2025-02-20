package com.bootcamp.microservice.bootcamp_microservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class BootcampRequest {
    private Long id;
    private String name;
    private String description;
    private List<Long> capacitiesId;
}
