package com.quinbay.SpringDemo.service;

import com.quinbay.SpringDemo.Client.SearchClient;
import com.quinbay.SpringDemo.dto.ProductBean;
import com.quinbay.SpringDemo.dto.ProductResponseDTO;
import com.quinbay.SpringDemo.dto.ProductRequestSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quinbay.SpringDemo.constants.SolrFieldNames;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SearchServiceIMPL implements SearchService {

    private List<ProductBean> searchTermBasedResponse(String query){
        List<ProductBean> response = new ArrayList<>();
        Map<String,Object> productsLocationBased = searchClient.getProducts(query);
        List<HashMap<String,Object>> listLocationBased = ((List<HashMap<String,Object>>)((HashMap<String,Object>)productsLocationBased.get("response")).get("docs"));
        for(HashMap<String,Object> mapObj : listLocationBased){
            ProductBean pb = new ProductBean();
            if((Integer)mapObj.get(SolrFieldNames.IN_STOCK)>0)
                pb.setInStock(true);
            else{
                pb.setInStock(false);
            }
            pb.setSalesPrice(Double.parseDouble(mapObj.get(SolrFieldNames.OFFER_PRICE).toString()));

            pb.setTitle(mapObj.get(SolrFieldNames.NAME).toString());

            pb.setDescription(mapObj.get(SolrFieldNames.DESCRIPTION).toString());

            response.add(pb);


        }
        return response;

    }
    @Autowired
    private SearchClient searchClient;
    @Override
    public ProductResponseDTO productSearchResponse(ProductRequestSearchDTO request) {
        ProductResponseDTO res = new ProductResponseDTO();
        List<ProductBean> al = searchTermBasedResponse(request.getSearchTerm());
        res.setProduct(al);
        String q = SolrFieldNames.STOCK_LOCATION+":"+request.getStockLocation();
        al = searchTermBasedResponse(q);
        res.setLocationBasedProducts(al);
        return res;
    }
}
