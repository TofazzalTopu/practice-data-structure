package com.example.practice.customAnnotation;

public class User {

    private Long id;
    private String name;


    @MethodInfo(author = "Pankaj", comments = "Main method", date = "Nov 17 2012", revision = 1)
    public String toString() {
        return "Overriden toString method";
    }

}
