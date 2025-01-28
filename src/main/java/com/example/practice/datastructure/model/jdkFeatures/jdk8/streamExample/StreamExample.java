package com.example.practice.datastructure.model.jdkFeatures.jdk8.streamExample;

import com.example.practice.datastructure.model.Employee;
import com.example.practice.datastructure.model.comparable.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) {

    }

    public static  void list(List<Person> people) {
        //    Implementations of Collector that implement various useful reduction operations, such as accumulating elements into collections, summarizing elements according to various criteria, etc.
//    The following are examples of using the predefined collectors to perform common mutable reduction tasks:

        //     Accumulate names into a List
        List<String> list = people.stream().map(Person::getName).collect(Collectors.toList());
        // Accumulate names into a TreeSet
        Set<String> set = people.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));
        // Convert elements to strings and concatenate them, separated by commas
         String joined = things.stream().map(Object::toString).collect(Collectors.joining(", "));
        // Compute sum of salaries of employee
        List<Employee> employees = new ArrayList<>();
         int total = employees.stream().collect(Collectors.summingInt(Employee::getSalary)));
        // Group employees by department
         Map<Department, List<Employee>> byDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        // Compute sum of salaries by department
         Map<Department, Integer> totalByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary)));
//         Partition students into passing and failing
        Map<Boolean, List<Student>> passingFailing =  students.stream().collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
//    Since: 1.8
    }


    public static void manipulateList(List<Person> personList) {
        //filtering the list based on age
        List<Person> filteredList = personList.stream().filter(person -> person.getAge() > 20).collect(Collectors.toList());
        System.out.println("Filtered List based on age");
        filteredList.forEach(person -> System.out.println(person.getName() + " " + person.getAge()));

        //sorting the list based on age
        List<Person> sortedList = personList.stream().sorted((p1, p2) -> p1.getAge() - p2.getAge()).collect(Collectors.toList());
        System.out.println("Sorted List based on age");
        sortedList.forEach(person -> System.out.println(person.getName() + " " + person.getAge()));

        //mapping the list based on name
        List<String> nameList = personList.stream().map(person -> person.getName()).collect(Collectors.toList());
        System.out.println("Name List");
        nameList.forEach(name -> System.out.println(name));

        //mapping the list based on name and age
        List<String> nameAgeList = personList.stream().map(person -> person.getName() + " " + person.getAge()).collect(Collectors.toList());
        System.out.println("Name and Age List");
        nameAgeList.forEach(nameAge -> System.out.println(nameAge));

        //converting the list to set
        Set<Person> personSet = personList.stream().collect(Collectors.toSet());
        System.out.println("Person Set");
        personSet.forEach(person -> System.out.println(person.getName() + " " + person.getAge()));

        //converting the list to TreeSet
        TreeSet<Person> personTreeSet = personList.stream().collect(Collectors.toCollection(TreeSet::new));
        System.out.println("Person TreeSet");
        personTreeSet.forEach(person -> System.out.println(person.getName() + " " + person.getAge()));

        //finding the average age
        double averageAge = personList.stream().collect(Collectors.averagingInt(Person::getAge));
        System.out.println("Average Age " + averageAge);

        //finding the sum of age
        int sumAge = personList.stream().collect(Collectors.summingInt(Person::getAge));
        System.out.println("Sum of Age " + sumAge);

        //finding the max age
        int maxAge = personList.stream().collect(Collectors.summarizingInt(Person::getAge)).getMax();
        System.out.println("Max Age " + maxAge);


}
