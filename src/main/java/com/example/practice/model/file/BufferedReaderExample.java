package com.example.practice.model.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BufferedReaderExample {

   public static void main(String[] args) {
      StringBuilder sb = new StringBuilder();
      try (BufferedReader br = Files.newBufferedReader(Paths.get("filename.txt"))) {
         // read line by line
         String line;
         while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
         }
      } catch (IOException e) {
         System.err.format("IOException: %s%n", e);
      }
      System.out.println(sb);
   }

   public static void readByBufferedReader() {
      try (FileReader reader = new FileReader("filename.txt");
            BufferedReader br = new BufferedReader(reader)) {
         // read line by line
         String line;
         while ((line = br.readLine()) != null) {
            System.out.println(line);
         }
      } catch (IOException e) {
         System.err.format("IOException: %s%n", e);
      }
   }

   public static List<List<String>> parseCsv(String csv, String separator, String quote) throws IOException {
      List<List<String>> list = new ArrayList<>();
      try(BufferedReader br = new BufferedReader(new FileReader(csv))){
         System.out.println();
         String line;
         while((line = br.readLine()) != null){
            String values[] = line.split(separator);
            list.add(Arrays.asList(values));
         }
      }

      return list;
   }
}
