package com.example.practice.datastructure.model.queue;

import java.util.Iterator;
import java.util.PriorityQueue;

public class QueuePollPeekExample {

   public static void main(String args[]) {
      PriorityQueue<String> queue = new PriorityQueue<>();
      queue.add("Amit");
      queue.offer("Vijay");
      queue.add("Karan");
      queue.add("Jai");
      queue.add("Rahul");
      System.out.println(queue.offer("Sikha"));
      System.out.println("head:" + queue.element());
      System.out.println("head:" + queue.peek());
      System.out.println("iterating the queue elements:");
      Iterator itr = queue.iterator();
      while (itr.hasNext()) {
         System.out.println(itr.next());
      }
      queue.remove();
      queue.poll();
      System.out.println("after removing two elements:");
      Iterator<String> itr2 = queue.iterator();
      while (itr2.hasNext()) {
         System.out.println(itr2.next());
      }

      PriorityQueue<Integer> intQueue = new PriorityQueue<Integer>();
      intQueue.add(2);
      intQueue.add(1);
      intQueue.add(5);
      intQueue.offer(3);
      intQueue.add(4);
      System.out.println(intQueue.offer(6));
      System.out.println("head:" + intQueue.element());
      System.out.println("head:" + intQueue.peek());

      intQueue.remove();
      intQueue.poll();
   }

}
