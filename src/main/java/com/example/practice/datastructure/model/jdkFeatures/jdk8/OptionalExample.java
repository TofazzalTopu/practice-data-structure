package com.example.practice.datastructure.model.jdkFeatures.jdk8;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        String message = "Hello World!";
        System.out.println("message -> " + message + "\n");

        Optional<String> genderOptional = Optional.of(message);
        System.out.println("Optional.of(message) -> " + genderOptional);
        System.out.println("Optional.of(message).get() -> " + genderOptional.get());
        try {
            Optional.of(null);
        } catch (java.lang.NullPointerException e) {
            System.out.println("Optional.of(null) -> java.lang.NullPointerException \n");
        }

        System.out.println("Optional.empty() -> " + Optional.empty() + "\n");

        System.out.println("Optional.ofNullable(null) -> " + Optional.ofNullable(null));
        System.out.println("Optional.ofNullable(message) -> " + Optional.ofNullable(message));
        System.out.printf("Optional.ofNullable(message).get() -> %s%n", Optional.ofNullable(message).get());
        String message2 = "FIRST VALUE %s";
//        System.out.println("FIRST VALUE -> %s%n", message2);
    }



}
