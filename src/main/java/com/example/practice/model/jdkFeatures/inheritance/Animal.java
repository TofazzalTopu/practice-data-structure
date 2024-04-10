package com.example.practice.model.jdkFeatures.inheritance;

public interface Animal {

    public Animal eat1();
    public void eat();

    public void makeSound();


}

interface Bird {
    int legs = 2;

    public void fly();
}

class Parrot implements Animal, Bird {

    @Override
    public Animal eat1() {
        return new Parrot();
    }

    @Override
    public void eat() {
        System.out.println("Parrots can eat up to 100 gms in a day");
    }

    @Override
    public void makeSound() {
        System.out.println("Parrots make sound of screech");
    }

    @Override
    public void fly() {
        System.out.println("Parrots can fly up to 50 miles in a day");
    }

    public static void main(String[] args) {
        Parrot parrot = new Parrot();
        parrot.eat();
        parrot.makeSound();
        parrot.fly();
    }


}


