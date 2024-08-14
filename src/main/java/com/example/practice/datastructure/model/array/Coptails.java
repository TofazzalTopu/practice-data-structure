package com.example.practice.datastructure.model.array;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.*;

public class Coptails {

    public static void main(String[] args){
        A();
        B();
    }

    public static int A(){
        int i = 0;
//        while (i < 5){
//            System.out.println( i+"a");
//            i++;
//        }
        int[] ints = { -9, 8, 2, -5, 7 };
        int s = ints.length;
        List<Integer> list = new ArrayList<>();
        Collections.sort(list);

        int j = 0;
        return j;
    }

    public static String B(){
        for(int i =0; i < 2; i++){
//            System.out.println("a");
        }
        try {
            List<String> lines = Files.readAllLines(Paths.get("hgdfh"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String a = "";
        System.out.println("a");
        return a;
    }
}
