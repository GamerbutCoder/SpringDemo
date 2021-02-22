package com.quinbay.SpringDemo.dto;

public class ProductRequestSearchDTO {
    private String searchTerm;

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Override
    public String toString() {
        return "ProductRequestSearchDTO{" +
                "searchTerm='" + searchTerm + '\'' +
                '}';
    }
}
