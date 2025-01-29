package com.example.practice.datastructure.model;

import com.example.practice.datastructure.model.jdkFeatures.jdk8.streamExample.Department;
import lombok.Data;

@Data
public class Employee {

    private String name;
    private int age;
    private double salary;

    private Department department;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

}


