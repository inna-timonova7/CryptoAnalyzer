package ru.javarush.timonova.cryptoanalyzer.files;

import lombok.SneakyThrows;
import ru.javarush.timonova.cryptoanalyzer.exceptions.ExceptionInFileProcessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {
    public FileProcessor() {
    }

    @SneakyThrows
    public static String readFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return stringBuilder.toString();
    }

    @SneakyThrows
    public static void writeToFile(String filePath, String str) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(str);
        } catch (IOException e) {
            throw new ExceptionInFileProcessing(e.getMessage(), e);
        }
    }
}

