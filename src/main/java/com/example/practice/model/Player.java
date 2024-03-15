package com.example.practice.model;

import java.util.Objects;

//@ToString
public class Player {

   String name;

   int score;

   public Player(String name, int score) {
      this.name = name;
      this.score = score;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (!(o instanceof Player)) {
         return false;
      }
      Player player = (Player) o;
      return score == player.score && name.equals(player.name);
   }

   @Override
   public int hashCode() {
      return Objects.hash(name, score);
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getScore() {
      return score;
   }

   public void setScore(int score) {
      this.score = score;
   }

   @Override
   public String toString(){
      return "Player {"
              + "name= "+ name +","
              + "score= " + score
              +"}";
   }
}
