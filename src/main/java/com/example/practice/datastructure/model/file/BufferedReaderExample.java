package com.example.practice.datastructure.model.file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BufferedReaderExample {

   public static String FILE_PATH = "/Users/mdtofazzalhossain/Documents/Files/TestDoc.rtf";

   public static void main(String[] args) throws IOException {
//      readByReadAllLines();
//      readFile();
//      readFileJava8();
      writeFile();

   }

   private static void readFileJava8()  throws IOException {
      StringBuilder sb = new StringBuilder();
      Path path = Paths.get(FILE_PATH);
      String fileContent = Files.readString(path);
      System.out.println(fileContent);
   }

   private static void writeFile()  throws IOException {
      //"Write into Temporary File"
      Path path = Files.writeString(Files.createTempFile("test", ".txt"), "This was posted on JD");
      System.out.println(path);
      String s = Files.readString(path);
      System.out.println("Read Temporary File" + s +"\n");

      String ss = Files.readString(Path.of(FILE_PATH));
      System.out.println(ss);
   }
   private static void readFile()  throws IOException {
      StringBuilder sb = new StringBuilder();
      try (BufferedReader br = Files.newBufferedReader(Paths.get(FILE_PATH))) {
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
   private String readFromInputStream(InputStream inputStream)  throws IOException {
      StringBuilder resultStringBuilder = new StringBuilder();
      try (BufferedReader br
                   = new BufferedReader(new InputStreamReader(inputStream))) {
         String line;
         while ((line = br.readLine()) != null) {
            resultStringBuilder.append(line).append("\n");
         }
      }
      return resultStringBuilder.toString();
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

   public static void readByReadAllLines() {
      List<String> lines = Collections.emptyList();
      int lineCount = 0;
      int wordCount = 0;
      try{
         lines = Files.readAllLines(Paths.get(FILE_PATH), StandardCharsets.UTF_8);
         lineCount += lines.size();
         for(int i = 0; i < lines.size(); i++){
            String[] words = lines.get(i).split("\\s+");
            wordCount += words.length;
            System.out.println("Line:" + lines.get(i));
            System.out.println("Words:" + Arrays.asList(words));
         }
         System.out.println("Lines: "+ lineCount);
         System.out.println("wordCount: "+ wordCount);
      } catch (Exception e){

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
