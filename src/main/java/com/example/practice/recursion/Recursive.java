package com.example.practice.recursion;

public class Recursive {
    static int factorial(int n){
        if (n == 1)
            return 1;
        else
            return(n * factorial(n-1));
    }

    static int n1=0,n2=1,n3=0;
    static void printFibo(int count){
        if(count>0){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.print(" "+n3);
            printFibo(count-1);
        }
    }


    public static void main(String[] args) {
        System.out.println("Factorial of 5 is: "+factorial(5));
        int count=15;
        System.out.print(n1+" "+n2);//printing 0 and 1
        printFibo(count-2);//n-2 because 2 numbers are already printed

        Operation op=new Operation();

        System.out.println("before change "+op.data);
        op.change(500);
        System.out.println("after change "+op.data);
    }
}

class Operation {
    int data = 50;

    void change(int data) {
        data = data + 100;//changes will be in the local variable only
    }
}
