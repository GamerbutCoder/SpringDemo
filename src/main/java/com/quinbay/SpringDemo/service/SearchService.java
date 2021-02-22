package com.quinbay.SpringDemo.service;

import com.quinbay.SpringDemo.dto.ProductResponseDTO;
import com.quinbay.SpringDemo.dto.ProductRequestSearchDTO;

public interface SearchService {
    ProductResponseDTO productSearchResponse(ProductRequestSearchDTO req);

}
