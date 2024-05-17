package ru.javarush.timonova.cryptoanalyzer.controller;

import lombok.SneakyThrows;
import ru.javarush.timonova.cryptoanalyzer.files.FileProcessor;
import ru.javarush.timonova.cryptoanalyzer.services.BruteForce;
import ru.javarush.timonova.cryptoanalyzer.services.Decrypt;
import ru.javarush.timonova.cryptoanalyzer.services.Encrypt;
import ru.javarush.timonova.cryptoanalyzer.files.FilesValidator;

import java.util.Collections;
import java.util.List;

public class CaesarCypherCoder {
    private FilesValidator filesValidator;
    private FileProcessor fileProcessor;

    public CaesarCypherCoder() {
        this.filesValidator = new FilesValidator();
        this.fileProcessor = new FileProcessor();
    }

    public void performEncryption(String inputFile, String outputFile, int key) {
        filesValidator.validateReadingFile(inputFile);
        filesValidator.validateForWriting(outputFile);

        List<String> sourceLines = Collections.singletonList(FileProcessor.readFile(inputFile));
        for (String str : sourceLines) {
            String encryptedLine = Encrypt.encrypt(str, key);
            FileProcessor.writeToFile(outputFile, encryptedLine);
        }
    }

    public void performDecryption(String inputFile, String outputFile, int key) {
        filesValidator.validateReadingFile(inputFile);
        filesValidator.validateForWriting(outputFile);

        List<String> sourceLines = Collections.singletonList(FileProcessor.readFile(inputFile));
        for (String str : sourceLines) {
            String decryptedLine = Decrypt.decrypt(str, key);
            FileProcessor.writeToFile(outputFile, decryptedLine);
        }
    }

    @SneakyThrows
    public void performBruteForcing(String inputFile, String outputFile) {
        filesValidator.validateReadingFile(inputFile);
        filesValidator.validateForWriting(outputFile);

        List<String> sourceLines = Collections.singletonList(FileProcessor.readFile(inputFile));
        StringBuilder builder = new StringBuilder();
        for (String sourceLine : sourceLines) {
            builder.append(sourceLine).append("\n");
        }
        String bruteForcedText = BruteForce.bruteForce(builder.toString());
        FileProcessor.writeToFile(outputFile, bruteForcedText);
    }
}
