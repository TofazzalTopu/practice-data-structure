package com.example.practice.model.file;


import java.util.Comparator;
import java.util.Objects;

import com.opencsv.bean.CsvBindByPosition;

public class CountryComparator implements Comparator<CountryComparator> {

   @CsvBindByPosition(position = 0)
   private String startIp;
   private int id;

   @CsvBindByPosition(position = 1)
   private String endIp;

   @CsvBindByPosition(position = 2)
   private String countryCode;

   @CsvBindByPosition(position = 3)
   private String country;

   @Override
   public int compare(CountryComparator c1, CountryComparator c2) {
      if(c1.id == c2.id){
         return 0;
      } else if(c1.id > c2.id){
         return 1;
      } else {
         return -1;
      }
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (!(o instanceof CountryComparator)) {
         return false;
      }
      CountryComparator country1 = (CountryComparator) o;
      return Objects.equals(startIp, country1.startIp) && endIp.equals(country1.endIp) && Objects.equals(countryCode, country1.countryCode)
            && Objects.equals(country, country1.country);
   }

   @Override
   public int hashCode() {
      return Objects.hash(startIp, endIp, countryCode, country);
   }



}
