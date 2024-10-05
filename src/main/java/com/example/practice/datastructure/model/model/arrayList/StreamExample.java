package com.example.practice.datastructure.model.model.arrayList;

import com.example.practice.customAnnotation.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void y() {
        LocalDate localDate = LocalDate.of(2015, 4, 4);
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("E, MMM dd, yyyy")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("MM/dd/yy")));
    }

    public static void x() {
        System.out.println(Stream.of("green", "yellow", "blue")
                .max((s1, s2) -> s1.compareTo(s2))
                .filter(s -> s.endsWith("n"))
                .orElse("yellow")
        );
    }

    int d = 0;
    private boolean is;
    private User user;

    public void add(User user) {
        this.user = user;
    }

    protected boolean isAdd() {
        return this.is;
    }

    public static void main(String[] args) {
//    y();
//    x();
//        List<Employee> employeeList = new ArrayList<>();
//        employeeList.addAll(Arrays.asList(new Employee("ABC", 10, "Female", "HR"),
//                new Employee("BBC", 20, "Male", "IT"),
//                new Employee("DBC", 30, "Female", "HR"), new Employee("FGH", 40, "Male", "IT")));
//        streamExample(employeeList);
        test();
    }

    public static void test() {
        int i = 10, j = 12;
        int a[] = {2,3};
        do for(int b : a)
            System.out.println(b+" ");
            while (j++ < 1);

        StringBuilder sb =new StringBuilder("buffering");
        sb.replace(2, 7, "BUFFER");
        sb.delete(2, 4);
        String s =sb.substring(1, 5);
        System.out.println("S: "+ s);

//        for (; ; ) {
//            if (i++ < j--) {
//                continue;
//            } else {
//                break;
//            }
////        System.out.println(1 +" "+ j);
//        }
//        System.out.println(String.format("Loal time: %tH:%tM:%tS", LocalTime.now(), LocalTime.now(), LocalTime.now()));


        int x = 0, y = 0;
//        try{
//        try{
//            System.out.println(x);
//            System.out.println(x/y);
//            System.out.println(y);
//
//        }catch (ArithmeticException e){
//            System.out.println("1");
//            throw e;
//        } catch (RuntimeException e){
//            System.out.println("2");
//            throw e;
//        }finally {
//            System.out.println("F");
//        }
//        }catch (Exception e){
//            System.out.println("Out");
//        }
    }


    public static void test1() {

        Supplier<String> i = () -> "car";
        Consumer<String> c = x -> System.out.println(x.toLowerCase());
        Consumer<String> d = x -> System.out.println(x.toUpperCase());
        c.andThen(d).accept(i.get());
        System.out.println("hgfg");
        Integer x = 3;
        Integer y = null;

        try {
            System.out.println(Integer.compareUnsigned(x, 3) == 0 || Integer.compareUnsigned(y, 0) == 0);
        } catch (Exception e) {
            System.out.println(e.getClass().toString());
        }
        try {
            System.out.println(y.compareTo(null) == 0 || true);
        } catch (Exception e) {
            System.out.println(e.getClass().toString());

        }
    }

    public static void streamExample(List<Employee> employeeList) {
        // print unique department
        employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

        // counting department and store in a map
        Map<Employee, Long> collect = employeeList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println();

        //Find average Age Gender
        Map<String, Double> averageAgeGroupAndByGender = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        averageAgeGroupAndByGender.entrySet().forEach(e -> System.out.println("Gender: " + e.getKey() + ", Average Age: " + e.getValue()));
        System.out.println();
        //Find sum of Age by Gender
        Map<String, Integer> sumOfAgeGroupAndByGender = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.summingInt(Employee::getAge)));
        sumOfAgeGroupAndByGender.entrySet().forEach(e -> System.out.println("Gender: " + e.getKey() + ", Total Age: " + e.getValue()));

    }
}
