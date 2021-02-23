package com.quinbay.SpringDemo.Client;

import com.quinbay.SpringDemo.dto.ProductRequestSearchDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "search-client", url="10.177.68.77:8983")
public interface SearchClient {
    // api: 10.177.68.40:8983/solr/productCollection/browse?q=samsung
    @RequestMapping(method = RequestMethod.GET,path = "/solr/productCollection/select")
    Map<String,Object> getProducts(@RequestParam("q") String q);

    @RequestMapping(method = RequestMethod.GET,path = "/solr/productCollection/select")
    Map<String,Object> getProductsLocationBased(@RequestParam("q") String prs);

}

