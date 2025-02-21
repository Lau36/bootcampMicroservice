package com.bootcamp.microservice.bootcamp_microservice.domain.utils;

import com.bootcamp.microservice.bootcamp_microservice.domain.model.BootcampWithCapacitiesModel;

import java.util.List;

public class Paginated {
    private int currentPage;
    private int totalPages;
    private long totalElements;
    private List<BootcampWithCapacitiesModel> bootcampWithCapacitiesModels;

    public Paginated(int currentPage, int totalPages, long totalElements, List<BootcampWithCapacitiesModel> bootcampWithCapacitiesModels) {
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.bootcampWithCapacitiesModels = bootcampWithCapacitiesModels;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public List<BootcampWithCapacitiesModel> getBootcamps() {
        return bootcampWithCapacitiesModels;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public void setBootcamps(List<BootcampWithCapacitiesModel> bootcampWithCapacitiesModels) {
        this.bootcampWithCapacitiesModels = bootcampWithCapacitiesModels;
    }
}
