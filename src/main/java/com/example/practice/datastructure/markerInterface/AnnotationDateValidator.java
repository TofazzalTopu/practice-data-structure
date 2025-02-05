package com.example.practice.datastructure.markerInterface;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AnnotationDateValidator {
    public static boolean isValidDateFormat(Object obj) {
        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(ValidDateFormat.class)) {
                field.setAccessible(true);
                ValidDateFormat annotation = field.getAnnotation(ValidDateFormat.class);
                String pattern = annotation.pattern();

                try {
                    String value = (String) field.get(obj);
                    if (value == null) return false;

                    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                    sdf.setLenient(false);
                    sdf.parse(value);
                    return true; // Valid date
                } catch (IllegalAccessException | ParseException e) {
                    return false; // Invalid date
                }
            }
        }
        return false; // No annotated fields found
    }
}
