package com.example.practice.datastructure.model.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedList1 {
   public static void main(String args[]){
      linkedListExample();

      LinkedList<String> al=new LinkedList<String>();
      al.add("Ravi");
      al.add("Vijay");
      al.add("Ravi");
      al.add("Ajay");

      Iterator<String> itr=al.iterator();
      while(itr.hasNext()){
         System.out.println(itr.next());
      }
   }

   public static void linkedListExample(){
      LinkedList<String> ll=new LinkedList<String>();
      System.out.println("Initial list of elements: "+ll);
      ll.add("Ravi");
      ll.add("Vijay");
      ll.add("Ajay");

      System.out.println("After invoking add(E e) method: "+ll);
      //Adding an element at the specific position
      ll.add(1, "Gaurav");
      System.out.println("After invoking add(int index, E element) method: "+ll);
      LinkedList<String> ll2=new LinkedList<String>();
      ll2.add("Sonoo");
      ll2.add("Hanumat");
      //Adding second list elements to the first list
      ll.addAll(ll2);
      System.out.println("After invoking addAll(Collection<? extends E> c) method: "+ll);
      LinkedList<String> ll3=new LinkedList<String>();
      ll3.add("John");
      ll3.add("Rahul");
      //Adding second list elements to the first list at specific position
      ll.addAll(1, ll3);
      System.out.println("After invoking addAll(int index, Collection<? extends E> c) method: "+ll);
      //Adding an element at the first position
      ll.addFirst("Lokesh");
      System.out.println("After invoking addFirst(E e) method: "+ll);
      //Adding an element at the last position
      ll.addLast("Harsh");
      System.out.println("After invoking addLast(E e) method: "+ll);

   }
}

