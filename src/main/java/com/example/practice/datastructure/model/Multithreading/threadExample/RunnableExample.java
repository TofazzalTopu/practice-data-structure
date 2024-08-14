package com.example.practice.datastructure.model.Multithreading.threadExample;

public class RunnableExample implements Runnable{
    @Override
    public void run() {
        System.out.println("thread is running...");
    }

    public static void main(String[] args){
        RunnableExample runnableExample = new RunnableExample();
        Thread thread = new Thread(runnableExample);
        thread.start();
    }
}
