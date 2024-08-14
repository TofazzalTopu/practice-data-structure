package com.example.practice.datastructure.model.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class DynamicArrayList {

   public static void main(String[] args) {
      /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int d, q, x, y;

      ArrayList<ArrayList<Integer>> lines = new ArrayList<>();
      for(int i = 0; i < n; i++){
         d = scanner.nextInt();
         lines.add(i, new ArrayList<Integer>());
         for(int j = 0; j < d; j++){
            lines.get(i).add(scanner.nextInt());
         }
      }

      q = scanner.nextInt();
      for(int i = 0; i < q; i++){
         x = scanner.nextInt();
         y = scanner.nextInt();
         try{
            System.out.println(lines.get(x-1).get(y-1));
         } catch(Exception e){
            System.out.println("ERROR!");
         }
      }
   }
}
