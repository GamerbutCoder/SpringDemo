package com.quinbay.SpringDemo.dto;

public class MyResponseDto {
    private String id;

    @Override
    public String toString() {
        return "MyResponseDto{" +
                "id='" + id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
