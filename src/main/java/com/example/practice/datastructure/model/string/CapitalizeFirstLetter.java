package com.example.practice.datastructure.model.string;

public class CapitalizeFirstLetter {


    public static void main(String[] args) {
        String sentence = "this is a sample sentence.";

        // Capitalize the first letter
        String capitalizedSentence = capitalizeFirstLetter(sentence);

        // Print the result
        System.out.println("Original Sentence: " + sentence);
        System.out.println("Capitalized Sentence: " + capitalizedSentence);
    }

    public static String capitalizeFirstLetter(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        // Capitalize the first letter and keep the rest unchanged
        return sentence.substring(0, 1).toUpperCase() + sentence.substring(1);
    }
}
