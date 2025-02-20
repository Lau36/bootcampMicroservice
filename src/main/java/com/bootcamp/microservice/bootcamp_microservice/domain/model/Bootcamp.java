package com.bootcamp.microservice.bootcamp_microservice.domain.model;

import com.bootcamp.microservice.bootcamp_microservice.domain.utils.Capacity;

import java.util.List;

public class Bootcamp {
    private int id;
    private String name;
    private String description;
    private List<Capacity> capacities;

    public Bootcamp(int id, String name, String description, List<Capacity> capacities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.capacities = capacities;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Capacity> getcapacities() {
        return capacities;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setcapacities(List<Capacity> capacities) {
        this.capacities = capacities;
    }
}
