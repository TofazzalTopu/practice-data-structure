package com.example.practice.model.arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListConversion {

    public static void main(String[] args){
        String[] geeks = {"Rahul", "Utkarsh", "Shubham", "Neelam"};
        //1
        List<String> al = new ArrayList<String>(Arrays.asList(geeks));
        System.out.println(al);
        // Adding some more values to the List.
        al.add("Shashank");
        al.add("Nishant");
        System.out.println("\nArrayList After adding two more Geeks: ");
        System.out.println(al);
        //2
        List<String> list = Arrays.asList(geeks);
        //3
        Collections.addAll(al, geeks);
        //4
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(10);
        integerList.add(20);

        Object[] objects = integerList.toArray();
        // Printing array of objects
        for (Object obj : objects)
            System.out.print(obj + " ");

        //5
        Integer[] arr = new Integer[al.size()];
        arr = al.toArray(arr);

        for (int i = 0; i < al.size(); i++) {
            arr[i] = integerList.get(i);
        }

        //6
        Integer arrr[] = integerList.stream().toArray(Integer[]::new);

        //7
        int arrrr[] = {1,2};
        List<Integer> l = Arrays.stream(arrrr).boxed().collect(Collectors.toList());
        List<Integer> output = IntStream.of(arrrr).boxed().collect(Collectors.toList());

        List<int[]> arrayList = Arrays.asList(arrrr);
        //8
        Integer a[] = arrayList.toArray(Integer[]::new);

        // ArrayList to Array Conversion
        int[] yyy = l.stream().mapToInt(i -> i).toArray();

    }
}
