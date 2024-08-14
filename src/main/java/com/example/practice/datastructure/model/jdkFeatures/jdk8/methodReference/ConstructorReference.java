package com.example.practice.datastructure.model.jdkFeatures.jdk8.methodReference;


//1) Reference to a Static Method
class StaticMethodReference {
    public static void saySomething(){
        System.out.println("Hello, this is static method.");
    }
    public static void main(String[] args) {
        // Referring static method
//        Sayable sayable = StaticMethodReference::saySomething;
        // Calling interface method
//        sayable.say();
    }
}


//2) Reference to an Instance Method
class InstanceMethodReference {

    public void saySomething(){
        System.out.println("Hello, this is non-static method.");
    }
    public static void main(String[] args) {
        InstanceMethodReference methodReference = new InstanceMethodReference(); // Creating object
        // Referring non-static method using reference
//        Sayable sayable = methodReference::saySomething;
        // Calling interface method
//        sayable.say();
        // Referring non-static method using anonymous object
//        Sayable sayable2 = new InstanceMethodReference()::saySomething; // You can use anonymous object also
        // Calling interface method
//        sayable2.say();
    }
}

//3) Reference to a Constructor
interface Messageable{
    Message getMessage(String msg);
}
class Message{
    Message(String msg){
        System.out.print(msg);
    }
}


public class ConstructorReference {
    public static void main(String[] args) {
        Messageable hello = Message::new;
        hello.getMessage("Hello");
    }
}





