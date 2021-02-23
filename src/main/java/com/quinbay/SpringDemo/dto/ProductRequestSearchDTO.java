package com.quinbay.SpringDemo.dto;

public class ProductRequestSearchDTO {
    private String searchTerm;
    private String stockLocation;

    public String getStockLocation() {
        return stockLocation;
    }

    public void setStockLocation(String stockLocation) {
        this.stockLocation = stockLocation;
    }

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
                ", stockLocation='" + stockLocation + '\'' +
                '}';
    }
}
