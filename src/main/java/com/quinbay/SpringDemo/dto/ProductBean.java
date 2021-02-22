package com.quinbay.SpringDemo.dto;

public class ProductBean {
    private boolean inStock;
    private double salesPrice;
    private String description,title;

    @Override
    public String toString() {
        return "ProductBean{" +
                "inStock=" + inStock +
                ", salesPrice=" + salesPrice +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public boolean isInStock() {
        return inStock;
    }


    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
