package com.bootcamp.microservice.bootcamp_microservice.domain.model;

import java.util.List;

public class BootcampModel {
    private Long id;
    private String name;
    private String description;
    private List<Long> capacitiesId;

    public BootcampModel(Long id, String name, String description, List<Long> capacitiesId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.capacitiesId = capacitiesId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Long> getCapacitiesId() {
        return capacitiesId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCapacitiesId(List<Long> capacitiesId) {
        this.capacitiesId = capacitiesId;
    }
}
