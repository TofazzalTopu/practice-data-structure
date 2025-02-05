package com.example.practice.datastructure.markerInterface;

public class AnnotationDateTest {
    public static void main(String[] args) {
        UserDateAnnotation user1 = new UserDateAnnotation("Alice", "2024-02-05"); // Valid date
        UserDateAnnotation user2 = new UserDateAnnotation("Bob", "05-02-2024");   // Invalid date format

        System.out.println("Is user1's date valid? " + AnnotationDateValidator.isValidDateFormat(user1));
        System.out.println("Is user2's date valid? " + AnnotationDateValidator.isValidDateFormat(user2));
    }
}
