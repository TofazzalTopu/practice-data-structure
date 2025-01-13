package com.example.practice.datastructure.model.random;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class RandomValueGeneration {

    //Summary of Use Cases:
    //Simple Random Numbers: Random or Math.random()
    //Multithreaded Applications: ThreadLocalRandom
    //Security-Sensitive Applications: SecureRandom
    //Random Strings: Combine Random/SecureRandom with a character pool.
    //Functional Style: Use Java 8+ streams.
    public static void main(String[] args) {
        usingUtilRandom();
        usingMathRandom();
        usingThreadLocalRandom();
        usingSecureRandom();
        usingRandomString();
        usingStreams();
    }

    //1. Using java.util.Random
    //Random is a simple pseudo-random number generator.
    public static void usingUtilRandom() {
        Random random = new Random();

        // Generate a random integer
        int randomInt = random.nextInt();
        System.out.println("Random Integer: " + randomInt);

        // Generate a random integer within a range (0 to 99)
        int randomIntRange = random.nextInt(100);
        System.out.println("Random Integer (0-99): " + randomIntRange);

        // Generate a random double (0.0 to 1.0)
        double randomDouble = random.nextDouble();
        System.out.println("Random Double (0.0-1.0): " + randomDouble);

        // Generate a random boolean
        boolean randomBoolean = random.nextBoolean();
        System.out.println("Random Boolean: " + randomBoolean);
    }


    //2. Using Math.random()
    //Math.random() generates a random double between 0.0 (inclusive) and 1.0 (exclusive).
    public static void usingMathRandom() {
        // Generate a random double (0.0 to 1.0)
        double randomDouble = Math.random();
        System.out.println("Random Double (0.0-1.0): " + randomDouble);

        // Generate a random integer within a range (e.g., 1 to 100)
        int randomInt = (int) (Math.random() * 100) + 1;
        System.out.println("Random Integer (1-100): " + randomInt);
    }

    //3. Using java.util.concurrent.ThreadLocalRandom
    //ThreadLocalRandom is suitable for multithreaded applications and provides better performance than Random.
    public static void usingThreadLocalRandom() {
        // Generate a random integer within a range (e.g., 1 to 100)
        int randomInt = ThreadLocalRandom.current().nextInt(1, 101);
        System.out.println("Random Integer (1-100): " + randomInt);

        // Generate a random double within a range (e.g., 1.0 to 10.0)
        double randomDouble = ThreadLocalRandom.current().nextDouble(1.0, 10.0);
        System.out.println("Random Double (1.0-10.0): " + randomDouble);

        // Generate a random boolean
        boolean randomBoolean = ThreadLocalRandom.current().nextBoolean();
        System.out.println("Random Boolean: " + randomBoolean);
    }

    //4. Using java.security.SecureRandom
    //SecureRandom provides cryptographically strong random values and is ideal for security-sensitive applications (e.g., generating passwords or tokens).
    public static void usingSecureRandom() {
        SecureRandom secureRandom = new SecureRandom();
        // Generate a random integer
        int randomInt = secureRandom.nextInt();
        System.out.println("Secure Random Integer: " + randomInt);

        // Generate a random integer within a range (0 to 99)
        int randomIntRange = secureRandom.nextInt(100);
        System.out.println("Secure Random Integer (0-99): " + randomIntRange);

        // Generate a random byte array
        byte[] randomBytes = new byte[16];
        secureRandom.nextBytes(randomBytes);
        System.out.println("Secure Random Bytes: " + java.util.Arrays.toString(randomBytes));
    }

    //5. Generating Random Strings
    //To generate random strings, you can use a combination of random methods (e.g., Random or SecureRandom) with a character pool.
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = RANDOM.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }

    public static void usingRandomString() {
        String randomString = generateRandomString(10);
        System.out.println("Random String: " + randomString);
        System.out.println();
    }


    //6. Using Streams (Java 8 and Above)
    //You can use streams to generate random numbers in a functional style.
    public static void usingStreams() {
        Random random = new Random();
        // Generate 5 random integers
        IntStream randomInts = random.ints(5, 1, 101); // 5 numbers between 1 and 100
        randomInts.forEach(System.out::println);
    }


}
