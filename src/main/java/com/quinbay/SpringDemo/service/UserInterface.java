package com.quinbay.SpringDemo.service;


import com.quinbay.SpringDemo.dto.MyRequestDto;

public interface UserInterface {
    boolean updateEmployee(MyRequestDto req, String id);
}
