package com.bootcamp.microservice.bootcamp_microservice.domain.utils;

import java.util.List;

public class CapacitiesId {
    private List<Long> capacitiesIds;

    public CapacitiesId(List<Long> capacitiesIds) {
        this.capacitiesIds = capacitiesIds;
    }

    public List<Long> getCapacitiesIds() {
        return capacitiesIds;
    }

    public void setCapacitiesIds(List<Long> capacitiesIds) {
        this.capacitiesIds = capacitiesIds;
    }
}
