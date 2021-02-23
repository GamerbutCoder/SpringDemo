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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/*class searchMulti extends Thread{
    ProductResponseDTO response;
    String query;
    searchMulti(ProductResponseDTO dto,String q){
        this.response = dto;
        this.query = q;
        this.start();
    }
    public void run(){
        SearchServiceIMPL obj = new SearchServiceIMPL();
        if(query.startsWith("stockLocation")){
            response.setLocationBasedProducts(obj.searchTermBasedResponse(query));
        }
        else {
            response.setProduct(obj.searchTermBasedResponse(query));
        }
    }
}*/

@Service
public class SearchServiceIMPL implements SearchService {

     List<ProductBean> searchTermBasedResponse(String query){
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
    public void awaitTerminationAfterShutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
    @Autowired
    private SearchClient searchClient;
    @Override
    public ProductResponseDTO productSearchResponse(ProductRequestSearchDTO request) {
        ProductResponseDTO res = new ProductResponseDTO();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Th1 = "+Thread.currentThread().getId());
                List<ProductBean> al = searchTermBasedResponse(request.getSearchTerm());
                res.setProduct(al);
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Th2 = "+Thread.currentThread().getId());
                String q = SolrFieldNames.STOCK_LOCATION+":"+request.getStockLocation();
                List<ProductBean> all = searchTermBasedResponse(q);
                res.setLocationBasedProducts(all);
            }
        });


        awaitTerminationAfterShutdown(executor);
        return res;

    }
}
