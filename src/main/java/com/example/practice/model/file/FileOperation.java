package com.example.practice.model.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

public class FileOperation {

   public static void main(String[] args) {

      try {
         String filePath = "/home/mkyong/test/phone.png";
         // file to bytes[]
         byte[] bytes = Files.readAllBytes(Paths.get(filePath));

         // bytes[] to file
         Path path = Paths.get("/home/mkyong/test/phone2.png");
         Files.write(path, bytes);
         //get path
         Path file = Files.write(path, bytes);

         System.out.println("Done");

      } catch (IOException e) {
         e.printStackTrace();
      }

   }

   private static void readFileToBytes(String filePath) throws IOException {

      File file = new File(filePath);
      byte[] bytes = new byte[(int) file.length()];

      // funny, if can use Java 7, please uses Files.readAllBytes(path)
      try(FileInputStream fis = new FileInputStream(file)){
         fis.read(bytes);
      }

   }

   // file to byte[], old and classic way, before Java 7
   private static void readFileToBytesJava7(String filePath) throws IOException {

      File file = new File(filePath);
      byte[] bytes = new byte[(int) file.length()];

      FileInputStream fis = null;
      try {

         fis = new FileInputStream(file);

         //read file into bytes[]
         fis.read(bytes);

      } finally {
         if (fis != null) {
            fis.close();
         }
      }
   }

   private static void getBytes() throws IOException {
      //...
      File file = new File("/path/file");
      byte[] bytes = FileUtils.readFileToByteArray(file);
   }

   private static final String OUTPUT_FORMAT = "Path: %-30s -> File Extension: %s";

   public static void getFileExtension() {
      String[] files = {
            "/path/foo.txt",
            ".",
            "..",
            "/path/run.exe",
            "/path/makefile",
            "/path/.htaccess",
            "/path/.tar.gz",
            "/path/../makefile",
            "/path/dir.test/makefile"
      };
      for (String file : files) {
         String output = String.format(OUTPUT_FORMAT, file, getFileExtension(file));
         System.out.println(output);
      }
   }

   /**
    * Fail for below cases
    * <p>
    * "/path/../makefile",
    * "/path/dir.test/makefile"
    */
   public static String getFileExtension(String fileName) {
      if (fileName == null) {
         throw new IllegalArgumentException("fileName must not be null!");
      }
      String extension = "";
      int index = fileName.lastIndexOf('.');
      if (index > 0) {
         extension = fileName.substring(index + 1);
      }
      return extension;
   }

   // System Property
   private static void printCurrentWorkingDirectory1() {
      String userDirectory = System.getProperty("user.dir");
      System.out.println(userDirectory);
   }

}
