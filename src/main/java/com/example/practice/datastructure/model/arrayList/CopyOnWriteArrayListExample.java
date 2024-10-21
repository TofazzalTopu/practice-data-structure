package com.example.practice.datastructure.model.arrayList;

import com.example.practice.datastructure.model.Employee;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample extends Thread {

    static CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();
    static ArrayList<String> arrayList = new ArrayList<String>();
    static Map<Integer, String> map = new HashMap<>();

    public void run() {
        // Child thread trying to add new element in the Collection object
        copyOnWriteArrayList.add("D");
        arrayList.add("L");
        map.put(4, "Four");
    }


    public static void main(String[] args) throws InterruptedException {
        copyOnWriteArrayList.add("A");
        copyOnWriteArrayList.add("B");
        copyOnWriteArrayList.add("c");

        // We create a child thread that is going to modify ArrayList l.
        CopyOnWriteArrayListExample t = new CopyOnWriteArrayListExample();
        t.start();

        Thread.sleep(1000);

        //CopyOnWriteArrayList is fail-safe
        // Now we iterate through the ArrayList and get exception.
        Iterator itr = copyOnWriteArrayList.iterator();
        while (itr.hasNext()) {
            String s = (String) itr.next();
            System.out.println(s);
            Thread.sleep(1000);
            //no exception on adding new element in copyOnWriteArrayList while operation/iterating
            copyOnWriteArrayList.add("E");
        }
        System.out.println(copyOnWriteArrayList);


        arrayList.add("I");
        arrayList.add("J");
        arrayList.add("K");

        //arrayList is not fail-safe
        Iterator arrayItr = arrayList.iterator();
        while (arrayItr.hasNext()) {
            String s = (String) arrayItr.next();
            System.out.println(s);
            Thread.sleep(1000);
            //throwing exception on adding new element in arrayList while operation/iterating
            arrayList.add("M");
        }
        System.out.println(arrayList);

        //map is not fail-safe
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        Set<Map.Entry<Integer, String>> mapSet = map.entrySet();
        mapSet.forEach(e -> {
            try {
                System.out.println(e.getKey() + " " + e.getValue());
                Thread.sleep(1000);
                //throwing exception on adding new element in map while operation/iterating
                //map.put(5, "Five");
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
        System.out.println(mapSet);

    }

    public static void example() {
        List<Employee> employeeList = new ArrayList<>();
//        1. CopyOnWriteArrayList(): Creates an empty list.
        CopyOnWriteArrayList a = new CopyOnWriteArrayList();

//        2. CopyOnWriteArrayList(Collection obj): Creates a list containing the elements of the specified collection,
//        in the order, they are returned by the collection’s iterator.
        CopyOnWriteArrayList b = new CopyOnWriteArrayList(employeeList);

//        3. CopyOnWriteArrayList(Object[] obj);: Creates a list holding a copy of the given array.
        Employee[] employeeArray = employeeList.toArray(new Employee[0]);
        CopyOnWriteArrayList c = new CopyOnWriteArrayList(employeeArray);
    }
}
