package com.bootcamp.microservice.bootcamp_microservice.domain.utils;

import java.util.List;

public class Capacity {
    private Long id;
    private String name;
    private List<Technology> technologies;

    public Capacity(Long id, String name, List<Technology> technologies) {
        this.id = id;
        this.name = name;
        this.technologies = technologies;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }
}
