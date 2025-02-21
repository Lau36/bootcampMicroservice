package com.bootcamp.microservice.bootcamp_microservice.domain.utils;

public class Pagination {
    private int page;
    private int size;
    private String sort;
    private SortDirection sortDirection;

    public Pagination(int page, int size, String sort, SortDirection sortDirection) {
        this.page = page;
        this.size = size;
        this.sort = sort;
        this.sortDirection = sortDirection;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public String getSort() {
        return sort;
    }

    public SortDirection getSortDirection() {
        return sortDirection;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setSortDirection(SortDirection sortDirection) {
        this.sortDirection = sortDirection;
    }
}
