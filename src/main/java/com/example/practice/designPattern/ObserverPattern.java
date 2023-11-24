package com.example.practice.designPattern;

import java.util.Observable;
import java.util.Observer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;


public class ObserverPattern {
}

//1 Create a ResponseHandler1 class that will implement the java.util.Observer interface.
class ResponseHandler1 implements Observer {
    private String resp;
    public void update(Observable obj, Object arg) {
        if (arg instanceof String) {
            resp = (String) arg;
            System.out.println("\nReceived Response: " + resp );
        }
    }
}// End of the ResponseHandler1 interface.


//2 Create a ResponseHandler2 class the will implement the java.util.Observer interface.
class ResponseHandler2 implements Observer {
    private String resp;
    public void update(Observable obj, Object arg) {
        if (arg instanceof String) {
            resp = (String) arg;
            System.out.println("\nReceived Response: " + resp );
        }
    }
}// End of the ResponseHandler2 interface.

// 3 Create an EventSource class that will extend the java.util.Observable class .
class EventSource extends Observable implements Runnable {
    @Override
    public void run() {
        try {
            final InputStreamReader isr = new InputStreamReader(System.in);
            final BufferedReader br = new BufferedReader(isr);
            while (true) {
                String response = br.readLine();
                setChanged();
                notifyObservers(response);
                System.out.println("response " + response);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        EventSource eventSource = new EventSource();
        Thread thread = new Thread(eventSource);
        thread.start();
    }
}// End of the Eventsource class.