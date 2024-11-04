package com.example.practice.datastructure.model.map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample2 extends Thread {
    static ConcurrentHashMap<Integer, String> h = new ConcurrentHashMap<Integer, String>();

    public void run() {
        try {
            Thread.sleep(1000);
            // Child thread trying to add Objects
            // Adding new element in the object
            h.put(103, "D"); // ConcurrentModification error not thrown Because of ConcurrentHashMap,
            // otherwise it through exception
        } catch (InterruptedException e) {
            System.out.println("Child Thread will add objects");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        h.put(100, "X");
        h.put(101, "Y");
        h.put(102, "Z");
        ConcurrentHashMapExample2 t = new ConcurrentHashMapExample2();
        t.start();
        for (Object o : h.entrySet()) {
            Object s = o;
            System.out.println(s);
            Thread.sleep(1000);
        }
        System.out.println(h);
    }
}
