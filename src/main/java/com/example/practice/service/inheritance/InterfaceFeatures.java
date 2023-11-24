package com.example.practice.service.inheritance;

public interface InterfaceFeatures {

    void get();
    void set();

    static String var = null;
    final String car = null;

    private String getString() {
        return null;
    }

    static String getMethod() {
        return null;
    }

    //Not allowed
//    static String getMethod();

    default String getDefaultMethod() {
        return null;
    }


}
