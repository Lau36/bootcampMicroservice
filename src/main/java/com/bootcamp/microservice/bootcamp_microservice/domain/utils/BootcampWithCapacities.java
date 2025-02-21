package com.bootcamp.microservice.bootcamp_microservice.domain.utils;

import java.util.List;

public class BootcampWithCapacities {
    private String id;
    private String name;
    private String description;
    private List<CapacityWithTechnologies> capacities;

    public BootcampWithCapacities(String id, String name, String description, List<CapacityWithTechnologies> capacities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.capacities = capacities;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<CapacityWithTechnologies> getcapacities() {
        return capacities;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setcapacities(List<CapacityWithTechnologies> capacities) {
        this.capacities = capacities;
    }
}
