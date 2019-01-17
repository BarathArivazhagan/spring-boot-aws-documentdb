package com.barath.app;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {

    @Id
    private Long customerId;


    private String firstName;

    private String lastName;

    private int age;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Customer(Long customerId, String firstName, String lastName,int age) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age=age;
    }

    public Customer() {
    }
}