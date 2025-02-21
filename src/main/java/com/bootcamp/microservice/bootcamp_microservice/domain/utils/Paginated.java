package com.bootcamp.microservice.bootcamp_microservice.domain.utils;

import java.util.List;

public class Paginated {
    private int currentPage;
    private int totalPages;
    private long totalElements;
    private List<BootcampWithCapacities> bootcampWithCapacities;

    public Paginated(int currentPage, int totalPages, long totalElements, List<BootcampWithCapacities> bootcampWithCapacities) {
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.bootcampWithCapacities = bootcampWithCapacities;
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

    public List<BootcampWithCapacities> getBootcamps() {
        return bootcampWithCapacities;
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

    public void setBootcamps(List<BootcampWithCapacities> bootcampWithCapacities) {
        this.bootcampWithCapacities = bootcampWithCapacities;
    }
}
