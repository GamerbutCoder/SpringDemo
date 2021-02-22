package com.quinbay.SpringDemo.dto;

public class MyRequestDto {
    private String firstName,lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyRequestDto{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
