package com.example.practice.datastructure.model.model.jdkFeatures.jdk8;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalExample {

    public static void main(String[] args) {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        System.out.println("Optional1: " + optional1);

        Optional<String> optional2 = Optional.ofNullable(null);
        System.out.println("Optional2: " + optional2.orElse("No value"));
        System.out.println("Optional2: " + optional2);
        System.out.println("Optional2.isPresent: " + optional2.isPresent());

        List<String> stringList = Optional.ofNullable("optionalName").stream().map(Object::toString).collect(Collectors.toList());
        System.out.println("stringList: " + stringList.size());
        String name = "";
        Optional<String> optionalName = Optional.of(name);
        System.out.println("optionalName: " + optionalName);
    }
}
