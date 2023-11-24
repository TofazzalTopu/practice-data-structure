package com.example.practice.model.Multithreading.runnable;

class Task implements Runnable {
    // The run method is called when the thread is started
    @Override
    public void run() {
        try {
            // Sleep for 1000 milliseconds (1 second)
            Thread.sleep(1000);
            // Print "Hello" to the console
            System.out.println("Hello");
        } catch (InterruptedException e) {
            // If an InterruptedException is thrown, print the stack trace
            e.printStackTrace();
        }
    }
}

class Main {
    // The main method is the entry point of the program
    public static void main(String[] args) {
        // Create a new thread using the Task class and start it
        Thread thread = new Thread(new Task());
        thread.start();
    }
}

