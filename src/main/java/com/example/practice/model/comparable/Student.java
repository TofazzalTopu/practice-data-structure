package com.example.practice.model.comparable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

class Student implements Comparable<Student> {
    int rollno;
    String name;
    int age;

    Student(int rollno, String name, int age) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student st) {
        if (age == st.age)
            return 0;
        else if (age > st.age)
            return 1;
        else
            return -1;
    }

    public static void main(String args[]) {
        ArrayList<Student> al = new ArrayList<Student>();
        al.add(new Student(101, "Vijay", 23));
        al.add(new Student(106, "Ajay", 27));
        al.add(new Student(105, "Jai", 21));

        Collections.sort(al);
        for (Student st : al) {
            System.out.println(st.rollno + " " + st.name + " " + st.age);
        }

        DoubleStream doubleStream = al.stream().sorted(Comparator.comparing(Student::getAge)).sorted().mapToInt(Student::getAge).asDoubleStream().sorted();
        List<Student> sort = al.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        List<Student> sortByAge = al.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
        List<Student> sortByName = al.stream().sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());
        List<Student> sortByNameAndRoll = al.stream().sorted(Comparator.comparing(Student::getName).thenComparing(Student::getRollno).reversed()).collect(Collectors.toList());
    }
}