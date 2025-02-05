package com.example.practice.datastructure.markerInterface;

import com.example.practice.util.DateValidator;

public class UserMarkerInterfaceTest {
    public static void main(String[] args) {
        UserForDateFormatTest user1 = new UserForDateFormatTest("Alice", "2024-02-05");
        UserForDateFormatTest user2 = new UserForDateFormatTest("Bob", "05-02-2024");  // Incorrect format

        System.out.println("Is user1's date valid? " + DateValidator.isValidDateFormat(user1));
        System.out.println("Is user2's date valid? " + DateValidator.isValidDateFormat(user2));
    }
}
