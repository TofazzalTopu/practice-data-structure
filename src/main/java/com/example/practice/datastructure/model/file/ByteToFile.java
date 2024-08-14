package com.example.practice.datastructure.model.file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ByteToFile {

    public static void main(String[] args) {

        try {
            // tested with character data and binary data
            // file to bytes[]
            byte[] bytes = Files.readAllBytes(Paths.get("/home/mkyong/test/file.txt"));
            // save byte[] to a file
            writeBytesToFile("/home/mkyong/test/file2.txt", bytes);
            writeBytesToFileNio("/home/mkyong/test/file3.txt", bytes);
            writeBytesToFileApache("/home/mkyong/test/file4.txt", bytes);
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //JDK 7 - FileOutputStream + try-with-resources
    private static void writeBytesToFile(String fileOutput, byte[] bytes) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileOutput)) {
            fos.write(bytes);
        }
    }

    //JDK 7, NIO, Files.write
    private static void writeBytesToFileNio(String fileOutput, byte[] bytes) throws IOException {
        Path path = Paths.get(fileOutput);
        Files.write(path, bytes);
    }

    // Apache Commons IO
    private static void writeBytesToFileApache(String fileOutput, byte[] bytes) throws IOException {
        FileUtils.writeByteArrayToFile(new File(fileOutput), bytes);
    }

}
