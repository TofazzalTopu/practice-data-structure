FROM openjdk:11
ADD target/practice-data-structure.jar practice-data-structure.jar
ENTRYPOINT ["java", "-jar", "practice-data-structure.jar"]
EXPOSE 8081