package com.example.practice.datastructure.model.file;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class OpenCsvExample {

   public static void main(String[] args) throws IOException, CsvException {

      String fileName = "c:\\test\\csv\\country.csv";
      try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
         List<String[]> r = reader.readAll();
         r.forEach(x -> System.out.println(Arrays.toString(x)));
      }
   }

   public static void readLineByLine(String file) throws FileNotFoundException {
      try (CSVReader reader = new CSVReader(new FileReader("file.csv"))) {
         String[] lineInArray;
         while ((lineInArray = reader.readNext()) != null) {
            System.out.println(lineInArray[0] + lineInArray[1] + "etc...");
         }
      } catch (IOException e) {
         e.printStackTrace();
      } catch (CsvValidationException e) {
         e.printStackTrace();
      }
   }

   public static void readBySemiColon(String fileName) throws FileNotFoundException {
      CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build(); // custom separator
      try (CSVReader reader = new CSVReaderBuilder(new FileReader(fileName)).withCSVParser(csvParser)   // custom CSV parser
                                                                            .withSkipLines(1)           // skip the first line, header info
                                                                            .build()) {
         List<String[]> r = reader.readAll();
         r.forEach(x -> System.out.println(Arrays.toString(x)));
      } catch (IOException | CsvException e) {
         e.printStackTrace();
      }
   }

   public static void ConvertCSVFileToObject() throws IOException {
      String fileName = "c:\\test\\csv\\country.csv";
      List<Country> beans = new CsvToBeanBuilder(new FileReader(fileName))
            .withType(Country.class)
            .build()
            .parse();
      beans.forEach(System.out::println);
   }

}
