package com.quinbay.SpringDemo.controller;


import com.quinbay.SpringDemo.dto.MyRequestDto;
import com.quinbay.SpringDemo.dto.MyResponseDto;
import com.quinbay.SpringDemo.service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
public class UserController {
    @Autowired
    private UserInterface userInterface;
    
    @PostMapping(path = "/update/employee/{id}")
    public boolean updateEmployee(@PathVariable String id, @RequestBody MyRequestDto req){
        return userInterface.updateEmployee(req,id);
    }


}
