package com.example.practice.datastructure.markerInterface;

public class UserDateAnnotation {

    private String name;

    @ValidDateFormat(pattern = "yyyy-MM-dd")  // Applying custom annotation
    private String birthDate;

    public UserDateAnnotation(String name, String birthDate) {
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
