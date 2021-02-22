package com.quinbay.SpringDemo.controller;


import com.quinbay.SpringDemo.dto.MyRequestDto;
import com.quinbay.SpringDemo.dto.MyResponseDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
    @GetMapping(path = "/employee/{id}")
    public MyResponseDto helloWorld(@PathVariable String id){
        MyResponseDto res = new MyResponseDto();
        res.setId(id);
        return res;
    }
    @GetMapping(path = "/hello")
    public String whatf(){
        return "Get";
    }

    @PostMapping(path="/hello")
    public String pst(){
        return "post!!";
    }

    @GetMapping(path = "/query")
    public String getParam(@RequestParam String q){
        System.out.println("Query: "+ q);
        return "Query: "+ q;
    }

    @PostMapping(path="/register")
    public String registerUser(@RequestBody MyRequestDto request){
        System.out.println(request.toString());
        return request.toString();
    }



}
