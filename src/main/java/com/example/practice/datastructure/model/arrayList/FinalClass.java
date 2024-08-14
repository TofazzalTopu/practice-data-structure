package com.example.practice.datastructure.model.arrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.practice.datastructure.model.file.Country;

public final class FinalClass {

    private final String id = "sdfs";
    private final Country country = new Country();

    public String getId() {
        return id;
    }

    public FinalClass() {
    }


    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(1);
        System.out.println(Collections.max(list) + 1);
    }

}
