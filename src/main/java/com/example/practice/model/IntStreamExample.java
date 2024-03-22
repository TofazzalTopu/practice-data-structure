package com.example.practice.model;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamExample {
    //    https://howtodoinjava.com/java8/intstream-examples/
    public static void main(String[] args) {
        IntStream.of(10);               //10
        IntStream.of(1, 2, 3);    //1,2,3
        IntStream.of(1, 2, 3).boxed().collect(Collectors.toSet());    //1,2,3

//      1.3. Infinite Streams with Iteration
//      The iterator() function is useful for creating infinite streams. Also, we can use this method to produce streams
//      where values are increment by any other value than 1.
//      Given example produces first 10 even numbers starting from 0.
        IntStream.iterate(0, i -> i + 2).limit(10)
                .forEach(System.out::println); //0,2,4,6,8,10,12,14,16,18

        IntStream stream = IntStream.generate(() -> {
            return (int) (Math.random() * 10000);
        });
//        stream.limit(10).forEach(System.out::println);

//        2. Iterating Over Values
//        To loop through the elements, stream support the forEach() operation. To replace simple for-loop using IntStream,
//        follow the same approach.
        IntStream.range(0, 4).forEach(System.out::println);
        IntStream.rangeClosed(0, 4).forEach(System.out::println);

//        4. Converting IntStream to Array Use
//        IntStream.toArray() method to convert from the stream to int array.
        int[] intArray = IntStream.of(1, 2, 3, 4, 5).toArray();

//        5. Converting IntStream to List
//        Collections in Java can not store the primitive values directly. They can store only instances/objects.
//      Using boxed() method of IntStream, we can get a stream of wrapper objects which can be collected by Collectors methods.
        List<Integer> list = IntStream.of(1, 2, 3, 4, 5).boxed().collect(Collectors.toList());


        List<Integer> result = Stream.of(1, 2, 3, 4).map(n -> n * 2).collect(Collectors.toList());
        result.forEach(System.out::println);
        filteringValues();
    }

    public static void filteringValues() {
        IntStream stream = IntStream.range(1, 100);
        List<Integer> primes = stream.filter(IntStreamExample::isPrime).boxed().collect(Collectors.toList());
        System.out.println(primes);
//        System.out.println(Arrays.stream(primes.toArray()).collect(Collectors.toSet()));
    }

    public static boolean isPrime(int number) {
//        IntPredicate isDivisible = index -> number % index == 0;
//        return number > 1 && IntStream.range(2, number).noneMatch(isDivisible);
//        return number > 1 && ntStream.rangeClosed(2, number/2).noneMatch(index -> number % index == 0);
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }

    //    @Test
    public void generatePrimeNumberListByStream() {
        List<Integer> primeNumbers =
                IntStream
                        .range(2, 30)
                        .filter(number -> IntStream.range(2, number)
                                .noneMatch(divider -> number % divider == 0))
                        .boxed()
                        .collect(Collectors.toList());
//        assertThat(primeNumbers, contains(2,3,5,7,11,13, 17,19, 23, 29));
    }
}
