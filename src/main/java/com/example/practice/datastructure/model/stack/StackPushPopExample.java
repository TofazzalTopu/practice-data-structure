package com.example.practice.datastructure.model.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackPushPopExample {
   public static void main(String args[]) {
      //creating an object of Stack class
      Stack<Integer> stk = new Stack<>();
      stk.push(34);
      System.out.println("stk "+ stk);
      stk.add(32);
      System.out.println("stk "+ stk);
      stk.add(0, 21);
      System.out.println("stk "+ stk);

      Stack<Integer> stak = new Stack<>();
      stak.add(11);
      stak.add(1, 10);
//      stk.addAll(stak);
      stk.addAll(2,stak);
      System.out.println("stk "+ stk);

      System.out.println("pop " + stk.pop());
      System.out.println("stk "+ stk);
      System.out.println("peek " + stk.peek());
      System.out.println("stk "+ stk);


      System.out.println("stack: " + stk);
      //pushing elements into the stack
//      pushelmnt(stk, 20);
//      pushelmnt(stk, 13);
//      pushelmnt(stk, 89);
//      pushelmnt(stk, 90);
//      pushelmnt(stk, 11);
//      pushelmnt(stk, 45);
//      pushelmnt(stk, 18);
      //popping elements from the stack
      popelmnt(stk);
      popelmnt(stk);
      //throws exception if the stack is empty
      try {
         popelmnt(stk);
      } catch (EmptyStackException e) {
         System.out.println("empty stack");
      }
   }

   static void pushelmnt(Stack stk, int x) { //performing push operation
      stk.push(x); //invoking push() method
      System.out.println("push -> " + x);
      System.out.println("stack: " + stk); //prints modified stack
   }

   static void popelmnt(Stack stk) { //performing pop operation
      System.out.print("pop -> ");
      Integer x = (Integer) stk.pop(); //invoking pop() method
      System.out.println(x);
      System.out.println("stack: " + stk); //prints modified stack
   }

}
