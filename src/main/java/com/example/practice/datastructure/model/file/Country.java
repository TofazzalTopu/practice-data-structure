package com.example.practice.datastructure.model.file;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.opencsv.bean.CsvBindByPosition;

public class Country implements Comparable<Country>{

   @CsvBindByPosition(position = 0)
   private String startIp;

   @CsvBindByPosition(position = 1)
   private String endIp;

   @CsvBindByPosition(position = 2)
   private String countryCode;

   @CsvBindByPosition(position = 3)
   private String country;

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (!(o instanceof Country)) {
         return false;
      }
      Country country1 = (Country) o;
      return Objects.equals(startIp, country1.startIp) && endIp.equals(country1.endIp) && Objects.equals(countryCode, country1.countryCode)
            && Objects.equals(country, country1.country);
   }

   @Override
   public int hashCode() {
      return Objects.hash(startIp, endIp, countryCode, country);
   }

   //  getters, setters, toString

   public String getStartIp() {
      return startIp;
   }

   public void setStartIp(String startIp) {
      this.startIp = startIp;
   }

   public String getEndIp() {
      return endIp;
   }

   public void setEndIp(String endIp) {
      this.endIp = endIp;
   }

   public String getCountryCode() {
      return countryCode;
   }

   public void setCountryCode(String countryCode) {
      this.countryCode = countryCode;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   @Override
   public int compareTo(Country country) {
      return this.countryCode.compareTo(country.getCountryCode());
   }

   public static void main(String[] args){
      int A[] = new int[]{3,1, 2, 5, 6};
      getSmall(A);
   }

   public static int getSmall(int A[]){
      int N = A.length;
      List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
//      System.out.println(list);
      list.removeIf(i -> i == 0);

      Collections.sort(list);
//      System.out.println(list);
      for(int i = 1; i <= N + 1; i++){
         if(!list.contains(i)){
            System.out.println(i);
            return i;
         }
      }
      return 0;
   }
   public static void main(String[] args, int a){}

}
