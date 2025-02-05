package com.example.practice.datastructure.markerInterface;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ValidDateFormat {
    String pattern() default "yyyy-MM-dd"; // Default date format
}

