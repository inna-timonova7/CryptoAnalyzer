package ru.javarush.timonova.cryptoanalyzer.files;

import lombok.SneakyThrows;
import ru.javarush.timonova.cryptoanalyzer.exceptions.ExceptionInFileProcessing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessor {

    @SneakyThrows
    public String readFile(String fileName) {
        try {
            Path filePath = Path.of(fileName);
            return Files.readAllLines(filePath).toString();
        } catch (IOException e) {
            throw new ExceptionInFileProcessing(e.getMessage(), e);
        }
    }

    @SneakyThrows
    public void writeToFile(String filePath, String str) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(str);
        } catch (IOException e) {
            throw new ExceptionInFileProcessing(e.getMessage(), e);
        }
    }
}

