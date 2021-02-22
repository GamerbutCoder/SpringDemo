package com.quinbay.SpringDemo.service.impl;


import com.quinbay.SpringDemo.dto.MyRequestDto;
import com.quinbay.SpringDemo.service.UserInterface;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserInterfaceImpl implements UserInterface {
    @Override
    public boolean updateEmployee(MyRequestDto req, String id) {
        System.out.println(req.toString()+" "+id);
        return false;
    }
}
