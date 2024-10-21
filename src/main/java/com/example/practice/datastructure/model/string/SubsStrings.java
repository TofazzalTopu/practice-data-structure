package com.example.practice.datastructure.model.string;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SubsStrings {

    public static void main(String[] args) throws IOException {
        String str = "185911698";
        String s = Files.readString(Path.of(""));
//        System.out.println(str.substring(0,3));
        System.out.println(str.substring(3));
    }
}
