package com.example.practice.model;

public class InstanceInitializer {
    int speed;

    InstanceInitializer(){System.out.println("speed is "+speed);}

    {
        speed=100;
    }

    public static void main(String args[]){
        InstanceInitializer b1=new InstanceInitializer();
        InstanceInitializer b2=new InstanceInitializer();
    }
}
