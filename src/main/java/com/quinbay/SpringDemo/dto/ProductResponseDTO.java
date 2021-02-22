package com.quinbay.SpringDemo.dto;

import java.util.List;

public class ProductResponseDTO {
    private List<ProductBean> products;

    public List<ProductBean> getProducts() {
        return products;
    }

    public void setProducts(List<ProductBean> products) {
        this.products = products;
    }
}
