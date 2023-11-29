package com.example.practice.model.mutableClass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public final class Example {

   private static final Logger log = LoggerFactory.getLogger(Example.class);

   private Long id = 1L;
   private String name = "sdfds";

   public Example() {
   }

   public Example(Long id, String name) {
      this.id = id;
      this.name = name;
   }


   public String getId() {
      return name;
   }

   public String getName() {
      return name;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (!(o instanceof Example)) {
         return false;
      }
      Example example = (Example) o;
      return id.equals(example.id) && name.equals(example.getName());
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, name);
   }


   public static void main(String[] args) {
      Example e = new Example(1L, "a");
      Example e1 = new Example(1L, "a");
      log.info("{}", e.equals(e1));
   }
}
