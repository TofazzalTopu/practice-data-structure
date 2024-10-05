package com.example.practice.dto;

public class User {

    private Long id;
    private String name;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;


    public User(Long id, String name, String firstName, String lastName, String phone, String address) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }


    public User() {
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", getName()=" + getName() + ", getFirstName()=" + getFirstName()
                + ", getLastName()=" + getLastName()  + ", getPhone()=" + getPhone()  + ", getAddress()=" + getAddress() + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
