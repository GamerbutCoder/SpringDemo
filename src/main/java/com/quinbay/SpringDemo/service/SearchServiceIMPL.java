package com.quinbay.SpringDemo.service;

import com.quinbay.SpringDemo.Client.SearchClient;
import com.quinbay.SpringDemo.dto.ProductBean;
import com.quinbay.SpringDemo.dto.ProductResponseDTO;
import com.quinbay.SpringDemo.dto.ProductRequestSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SearchServiceIMPL implements SearchService {
    @Autowired
    private SearchClient searchClient;
    @Override
    public ProductResponseDTO productSearchResponse(ProductRequestSearchDTO request) {
        Map<String,Object> products = searchClient.getProducts(request.getSearchTerm());
        // products.get("response").get("docs").
        List<HashMap<String,Object>> list = ((List<HashMap<String,Object>>)((HashMap<String,Object>)products.get("response")).get("docs"));
        List<ProductBean> response = new ArrayList<>();
        for(HashMap<String,Object> mapObj : list){
            ProductBean pb = new ProductBean();
            if((Integer)mapObj.get("isInStock")>0)
                    pb.setInStock(true);
            else{
                pb.setInStock(false);
            }
            //System.out.println(pb.isInStock());
            pb.setSalesPrice(Double.parseDouble(mapObj.get("offerPrice").toString()));
            //System.out.println(mapObj.get("offerPrice").toString());
            pb.setTitle(mapObj.get("name").toString());
            //System.out.println(mapObj.get("name").toString());
            pb.setDescription(mapObj.get("description").toString());
            //System.out.println(mapObj.get("description").toString());
            response.add(pb);
            //System.out.println(response);

        }

        ProductResponseDTO res = new ProductResponseDTO();
        res.setProduct(response);
        return res;
    }
}
