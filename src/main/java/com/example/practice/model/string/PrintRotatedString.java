package com.example.practice.model.string;

// A simple Java program to generate all rotations
// of a given string
public class PrintRotatedString {

//    Print all the rotated string.
   static void printRotatedString1(String str) {
      int len = str.length();
      // Generate all rotations one by one and print
      StringBuffer sb;
      for (int i = 0; i < len; i++) {
         sb = new StringBuffer();
         int j = i;  // Current index in str
         int k = 0;  // Current index in temp
         // Copying the second part from the point of rotation.
         for (int k2 = j; k2 < str.length(); k2++) {
            sb.insert(k, str.charAt(j));
            k++;
            j++;
         }
         // Copying the first part from the point of rotation.
         j = 0;
         while (j < i) {
            sb.insert(k, str.charAt(j));
            j++;
            k++;
         }
         System.out.println(sb);
      }
   }

   // Print all the rotated string.
   static void printRotatedString(String str)
   {
      int n = str.length();

      StringBuffer sb = new StringBuffer(str);
      // Concatenate str with itself
      sb.append(str);

      // Print all substrings of size n.
      // Note that size of sb is 2n
      for (int i = 0; i < n; i++)
      {
         for (int j=0; j != n; j++)
            System.out.print(sb.charAt(i + j));
         System.out.println();
      }
   }
   // Driver method
   public static void main(String[] args)
   {
      String  str = new String("geeks");
      printRotatedString(str);
   }
}
