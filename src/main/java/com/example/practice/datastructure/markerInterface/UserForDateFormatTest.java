package com.example.practice.datastructure.markerInterface;


public class UserForDateFormatTest implements DateFormatValidatable {
    private String name;
    private String birthDate; // Expected format: yyyy-MM-dd

    public UserForDateFormatTest(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
