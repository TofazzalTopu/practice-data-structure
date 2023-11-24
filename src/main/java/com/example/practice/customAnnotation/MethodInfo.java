package com.example.practice.customAnnotation;


import java.lang.annotation.*;

//https://www.digitalocean.com/community/tutorials/java-annotations
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo{
    String author() default "Pankaj";
    String date();
    int revision() default 1;
    String comments();
}
