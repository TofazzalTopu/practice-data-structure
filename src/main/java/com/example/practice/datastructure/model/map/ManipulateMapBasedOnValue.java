package com.example.practice.datastructure.model.map;

import com.example.practice.datastructure.model.Employee;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ManipulateMapBasedOnValue {

    public static void main(String[] args) {
        List<Employee> employeeList = List.of(
                new Employee("a", 10, 100),
                new Employee("b", 11, 200),
                new Employee("c", 12, 300),
                new Employee("d", 13, 400),
                new Employee("e", 14, 500)
        );


        employeeList.stream().map(e -> {
            if (e.getAge() > 10) e.setSalary(e.getSalary() * 1.1);
            return e;
        }).collect(Collectors.toList());
        StringJoiner j = new StringJoiner(",");
        String joined = String.join(" and ", employeeList.stream().map(Employee::getName).collect(Collectors.toList()));
        System.out.println(employeeList);
    }

}
