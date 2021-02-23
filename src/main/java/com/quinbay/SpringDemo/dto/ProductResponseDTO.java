package com.quinbay.SpringDemo.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductResponseDTO {
   private List<ProductBean> product;
   private List<ProductBean> locationBasedProducts;

    public List<ProductBean> getLocationBasedProducts() {
        return locationBasedProducts;
    }

    public void setLocationBasedProducts(List<ProductBean> locationBasedProducts) {
        this.locationBasedProducts = locationBasedProducts;
    }

    public List<ProductBean> getProduct() {
        return product;
    }

    public void setProduct(List<ProductBean> product) {
        this.product = product;
    }
}
