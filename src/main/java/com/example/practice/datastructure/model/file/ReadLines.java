package com.example.practice.datastructure.model.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadLines {

   public static void main(String[] args) throws IOException {
//      File file = new File("/Users/mdtofazzalhossain/Documents/Files/TestDoc.rtf");
      Path path = Path.of("/Users/mdtofazzalhossain/Documents/Files/TestDoc.rtf");
      List<String> lines = Files.readAllLines(path);
//      System.out.println(Files.readAllLines(path));

//      FileInputStream fileInputStream = new FileInputStream(file);
//      InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
//      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

      String line;
      int wordCount = 0;
      int characterCount = 0;
      int paraCount = 0;
      int whiteSpaceCount = 0;
      int sentenceCount = 0;

      for(int i=0; i < lines.size(); i++){
         line = lines.get(i);
         characterCount += line.length();
         String words[] = line.split("\\s+");
         wordCount += words.length;
         whiteSpaceCount += wordCount - 1;
         String sentence[] = line.split("[!?.:]+");
         sentenceCount += sentence.length;
      }
//
//      while ((line = bufferedReader.readLine()) != null) {
//         if (line.equals("")) {
//            paraCount += 1;
//         } else {
//            characterCount += line.length();
//            String words[] = line.split("\\s+");
//            System.out.println("words "+ words);
//            wordCount += words.length;
//            whiteSpaceCount += wordCount - 1;
//            String sentence[] = line.split("[!?.:]+");
//            sentenceCount += sentence.length;
//         }
//      }
      if (sentenceCount >= 1) {
         paraCount++;
      }
      System.out.println("Total word count = " + wordCount);
      System.out.println("Total number of sentences = " + sentenceCount);
      System.out.println("Total number of characters = " + characterCount);
      System.out.println("Number of paragraphs = " + paraCount);
      System.out.println("Total number of whitespaces = " + whiteSpaceCount);
   }

}
