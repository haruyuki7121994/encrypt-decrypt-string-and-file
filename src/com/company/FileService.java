package com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileService {
    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName))).trim();
    }

    public static void writeToFile(String fileName, String content) throws IOException {
        File file = new File(fileName); // some file

        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.print(content);
        }
    }
}
