package com.quinbay.SpringDemo.service;

import com.quinbay.SpringDemo.dto.ProductBean;
import com.quinbay.SpringDemo.dto.ProductResponseDTO;
import com.quinbay.SpringDemo.dto.ProductRequestSearchDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceIMPL implements SearchService {
    @Override
    public ProductResponseDTO productSearchResponse(ProductRequestSearchDTO request) {
        List<ProductBean> al = new ArrayList<>();
        ProductBean obj = new ProductBean();
        obj.setInStock(true);
        obj.setSalesPrice(1234);
        obj.setDescription("blah blah blah");
        obj.setTitle("Samsung Galaxy dumb");
        al.add(obj);
       obj = new ProductBean();
        obj.setTitle("Samsung");
        obj.setSalesPrice(2345);
        obj.setInStock(false);
        obj.setDescription("bleh bleh");
        al.add(obj);
        ProductResponseDTO response = new ProductResponseDTO();
        response.setProducts(al);
        return response;
    }
}
