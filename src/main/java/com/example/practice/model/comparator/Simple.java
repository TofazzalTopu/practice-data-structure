package com.example.practice.model.comparator;

import java.util.*;

class Simple {
    public static void main(String args[]) {

        ArrayList al = new ArrayList();
        al.add(new Student(101, "Vijay", 23));
        al.add(new Student(106, "Ajay", 27));
        al.add(new Student(105, "Jai", 21));

        System.out.println("Sorting by Name");

        Collections.sort(al, new NameComparator());
        Iterator itr = al.iterator();
        while (itr.hasNext()) {
            Student st = (Student) itr.next();
            System.out.println(st.rollno + " " + st.name + " " + st.age);
        }

        System.out.println("Sorting by age");

        Collections.sort(al, new AgeComparator());
        Iterator itr2 = al.iterator();
        while (itr2.hasNext()) {
            Student st = (Student) itr2.next();
            System.out.println(st.rollno + " " + st.name + " " + st.age);
        }


        ArrayList<Student> studentArrayList = new ArrayList<Student>();
        studentArrayList.add(new Student(101, "Vijay", 23));
        studentArrayList.add(new Student(106, "Ajay", 27));
        studentArrayList.add(new Student(105, "Jai", 21));

        //Sorting elements on the basis of name
        Comparator<Student> cm1 = Comparator.comparing(Student::getName);
        Collections.sort(studentArrayList, cm1);
        System.out.println("Sorting by Name");
        for (Student st : studentArrayList) {
            System.out.println(st.rollno + " " + st.name + " " + st.age);
        }
        //Sorting elements on the basis of age
        Comparator<Student> cm2 = Comparator.comparing(Student::getAge);
        Collections.sort(studentArrayList, cm2);
        System.out.println("Sorting by Age");
        for (Student st : studentArrayList) {
            System.out.println(st.rollno + " " + st.name + " " + st.age);
        }


        ArrayList<String> list = new ArrayList<String>();//Creating arraylist
        list.add("Ravi");//Adding object in arraylist
        list.add("Vijay");
        list.add("Ravi");
        list.add("Ajay");
        //Traversing list through Iterator
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        List<String> stringList = new ArrayList<>();
        //Creating arraylist
        stringList.add("Ravi");//Adding object in arraylist
        stringList.add("Vijay");
        stringList.add("Ravi");
        stringList.add("Ajay");
        //Traversing list through Iterator
        Iterator stringIterator = stringList.iterator();
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }

    }
}



