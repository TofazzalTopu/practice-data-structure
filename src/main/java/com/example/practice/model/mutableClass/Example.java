package com.example.practice.model.mutableClass;

import java.util.Objects;

public final class Example {

   private final Long id = 1L;
   private final String name = "sdfds";

   public Example() {
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
      return id.equals(example.id) && name.equals(example.name);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, name);
   }

}
