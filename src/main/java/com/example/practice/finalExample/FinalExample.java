package com.example.practice.finalExample;

import java.io.File;

public class FinalExample {
    String s;
    File f;
}


class Bike {

    final void run() {
        System.out.println("running");
    }
}

class Honda extends Bike {
    //    void run(){System.out.println("running safely with 100kmph");}
    final int speedlimit;//blank final variable

    Honda() {
        speedlimit = 70; //It can be initialized only in constructor.
        System.out.println(speedlimit);
    }

    public static void main(String args[]) {
        Honda honda = new Honda();
        honda.run();

        final int i;
        i = 20;
        System.out.println(i);
    }
}
