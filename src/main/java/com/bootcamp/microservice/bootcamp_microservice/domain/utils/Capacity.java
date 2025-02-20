package com.bootcamp.microservice.bootcamp_microservice.domain.utils;

import java.util.List;

public class Capacity {
    private Long id;
    private String name;
    private List<Technology> technologiesList;

    public Capacity(Long id, String name, List<Technology> technologiesList) {
        this.id = id;
        this.name = name;
        this.technologiesList = technologiesList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTechnologiesList(List<Technology> technologiesList) {
        this.technologiesList = technologiesList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Technology> getTechnologiesList() {
        return technologiesList;
    }
}
