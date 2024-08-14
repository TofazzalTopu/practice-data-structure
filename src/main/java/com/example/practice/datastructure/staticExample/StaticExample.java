package com.example.practice.datastructure.staticExample;

public class StaticExample {
    static int x  = 0;
    int a  = 0;

    static {
         x  = 10;
//         a = 10; //Non-static field 'test' cannot be referenced from a static context
    }

    public static void main(String[] args){
        System.out.println(x);
    }
}
