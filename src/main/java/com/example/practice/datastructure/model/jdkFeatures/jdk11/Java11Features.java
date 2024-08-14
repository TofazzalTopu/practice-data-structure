package com.example.practice.datastructure.model.jdkFeatures.jdk11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lombok.NonNull;

public class Java11Features {

   public static void FileMethods() throws IOException {
      //   3.2. New File Methods
      //   Additionally, it's now easier to read and write Strings from files.
      //   We can use the new readString and writeString static methods from the Files class:
      Path filePath = Files.writeString(Files.createTempFile(Path.of("tempDir"), "demo", ".txt"), "Sample text");
      String fileContent = Files.readString(filePath);
      //      assertThat(fileContent).isEqualTo("Sample text");
   }

   public static void stringMethods() throws IOException {
      //   3.1. New String Methods
      //   Java 11 adds a few new methods to the String class: isBlank, lines, strip, stripLeading, stripTrailing, and repeat.
      //   Let's see how we can make use of the new methods to extract non-blank, stripped lines from a multi-line string:
      //repeat
      String rp = "=".repeat(2);
      System.out.println(rp);

      //lines()
      String str = "JD\nJD\nJD";
      System.out.println(str);
      System.out.println(str.lines().collect(Collectors.toList()));

      String strip = " JD ";
      System.out.print("Start");
      System.out.print(strip.strip());
      System.out.println("End");

      System.out.print("Start");
      System.out.print(strip.stripLeading());
      System.out.println("End");

      System.out.print("Start");
      System.out.print(strip.stripTrailing());
      System.out.println("End");

      String multilineString = "Baeldung helps \n \n developers \n explore Java.";
      List<String> lines = multilineString.lines().filter(line -> !line.isBlank()).map(String::strip).collect(Collectors.toList());
      //   assertThat(lines).containsExactly("Baeldung helps", "developers", "explore Java.");
      //   These methods can reduce the amount of boilerplate involved in manipulating string objects, and save us from having to import libraries.
   }

   public static void CollectionToAnArray() throws IOException {
      //      3.3. Collection to an Array
      //      The java.util.Collection interface contains a new default toArray method which takes an IntFunction argument.
      //            This makes it easier to create an array of the right type from a collection:
      List sampleList = Arrays.asList("Java", "Kotlin");
      String[] sampleArray = (String[]) sampleList.toArray(String[]::new);
      //      assertThat(sampleArray).containsExactly("Java", "Kotlin");
   }

   public static void notPredicateMethod() throws IOException {
      //      3.4.The Not Predicate Method
      //      A static not method has been added to the Predicate interface. We can use it to negate an existing predicate, much like the negate
      //      method:

      List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
      List withoutBlanks = sampleList.stream().filter(Predicate.not(String::isBlank)).collect(Collectors.toList());
      //      assertThat(withoutBlanks).containsExactly("Java", "Kotlin");
      //      While not(isBlank) reads more naturally than isBlank.negate(), the big advantage is that we can also use not with method references,
      //      like not(String:isBlank).
   }

   public static void localVariableSyntaxForLambda() throws IOException {
      //3.5. Local-Variable Syntax for Lambda
      //      Support for using the local variable syntax (var keyword) in lambda parameters was added in Java 11.
      //      We can make use of this feature to apply modifiers to our local variables, like defining a type annotation:
      //      If you need to apply an annotation just as @Nullable, you cannot do that without defining the type. Limitation of this feature - You
      //      must specify the type var on all parameters or none. Things like the following are not possible:
      List<String> sampleList = Arrays.asList("Java", "Kotlin");
      String resultString = sampleList.stream().map((@NonNull var x) -> x.toUpperCase()).collect(Collectors.joining(", "));
      //      assertThat(resultString).isEqualTo("JAVA, KOTLIN");
   }

   public static void HTTPClient() throws IOException, InterruptedException {
      //      3.6. HTTP Client
      //      The new HTTP client from the java.net.http package was introduced in Java 9. It has now become a standard feature in Java 11.
      //      The new HTTP API improves overall performance and provides support for both HTTP/1.1 and HTTP/2:

      HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).connectTimeout(Duration.ofSeconds(20)).build();
      HttpRequest httpRequest = HttpRequest.newBuilder().GET().uri(URI.create("http://localhost:" + "port")).build();
      HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
      //      assertThat(httpResponse.body()).isEqualTo("Hello from the server!");
   }

   public static void RunningJavaFiles()  {
      //      3.8. Running Java Files
      //      A major change in this version is that we don't need to compile the Java source files with javac explicitly anymore:
      //      $ javac HelloWorld.java
      //      $ java HelloWorld
      //      Hello Java 8!

      //      Instead, we can directly run the file using the java command:
      //      $ java HelloWorld.java
      //      Hello Java 11!
   }

   //   4.4) Nested Based Access Control
   public static void NestedBasedAccessControl() {
     /* public class Main {

         public void myPublic() {
         }

         private void myPrivate() {
         }

         class Nested {

            public void nestedPublic() {
               myPrivate();
            }
         }
      }*/
   }
   //   3.7. Nest Based Access Control
   //4. Performance Enhancements
   //4.1. Dynamic Class-File Constants
   //4.2. Improved Aarch64 Intrinsics
   //4.3. A No-Op Garbage Collector
   //4.4. Flight Recorder

   public static void GarbageCollector() throws IOException, InterruptedException {
      //      4.3. A No-Op Garbage Collector
      //      A new garbage collector called Epsilon is available for use in Java 11 as an experimental feature.
      //      It's called a No-Op (no operations) because it allocates memory but does not actually collect any garbage. Thus, Epsilon is
      //      applicable for simulating out of memory errors.

      //      Obviously Epsilon won't be suitable for a typical production Java application; however, there are a few specific use-cases where it
      //      could be useful:

      //      Performance testing
      //      Memory pressure testing
      //      VM interface testing and
      //            Extremely short-lived jobs
      //      In order to enable it, use the -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC flag.
   }

}



