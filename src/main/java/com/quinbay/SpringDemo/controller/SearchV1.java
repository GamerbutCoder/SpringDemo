package com.quinbay.SpringDemo.controller;

import com.quinbay.SpringDemo.dto.ProductResponseDTO;
import com.quinbay.SpringDemo.dto.ProductRequestSearchDTO;
import com.quinbay.SpringDemo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchV1 {
    @Autowired
    private SearchService searchService;

    @PostMapping(path = "/search")
    public ProductResponseDTO search(@RequestBody ProductRequestSearchDTO request){
        return searchService.productSearchResponse(request);
    }

}
