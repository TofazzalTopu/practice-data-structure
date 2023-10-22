package com.example.practice.service.inheritance;

//Exception, Covariant return type example
public class Dog implements Animal {
    @Override
    public int length() throws IndexOutOfBoundsException {
        return 0;
    }

    @Override
    public int getName() {
        try {

        } catch (Exception e){

        }
        return 0;
    }

    //Covariant return type
    @Override
    public Dog getBehaviour() {
        return new Dog();
    }

    @Override
    public int defaultMethod() {
        return Animal.super.defaultMethod();
//        return 3;
    }
}
