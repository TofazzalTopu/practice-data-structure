package com.example.practice.util;

import com.example.practice.datastructure.markerInterface.DateFormatValidatable;
import com.example.practice.datastructure.markerInterface.UserForDateFormatTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidator {
    public static boolean isValidDateFormat(Object obj) {
        if (obj instanceof DateFormatValidatable) {  // Check if the object implements the marker interface
            UserForDateFormatTest user = (UserForDateFormatTest) obj;
            String date = user.getBirthDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);  // Strict date validation

            try {
                sdf.parse(date);
                return true;  // Valid date format
            } catch (ParseException e) {
                return false; // Invalid date format
            }
        }
        return false; // Object is not an instance of DateFormatValidatable
    }
    public void validateDateFormat(Object obj) {
        if (isValidDateFormat(obj)) {
            System.out.println("Date format is valid.");
        } else {
            System.out.println("Date format is invalid.");
        }
    }
}

