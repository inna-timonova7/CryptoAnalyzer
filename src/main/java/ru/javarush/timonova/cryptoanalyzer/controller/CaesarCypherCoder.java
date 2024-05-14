package ru.javarush.timonova.cryptoanalyzer.controller;

import ru.javarush.timonova.cryptoanalyzer.files.FileProcessor;
import ru.javarush.timonova.cryptoanalyzer.services.BruteForce;
import ru.javarush.timonova.cryptoanalyzer.services.Decode;
import ru.javarush.timonova.cryptoanalyzer.services.Encode;
import ru.javarush.timonova.cryptoanalyzer.files.FilesValidator;

import java.util.*;

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

        List<String> sourceLines = Collections.singletonList(fileProcessor.readFile(inputFile));
        for (String str : sourceLines) {
            String encryptedLine = Encode.encrypt(str, key);
            fileProcessor.writeToFile(outputFile, encryptedLine);
        }
    }

    public void performDecryption(String inputFile, String outputFile, int key) {
        filesValidator.validateReadingFile(inputFile);
        filesValidator.validateForWriting(outputFile);

        List<String> sourceLines = Collections.singletonList(fileProcessor.readFile(inputFile));
        for (String str : sourceLines) {
            String decryptedLine = Decode.decrypt(str, key);
            fileProcessor.writeToFile(outputFile, decryptedLine);
        }
    }

    public void performBruteForcing(String inputFile, String outputFile) {
        filesValidator.validateReadingFile(inputFile);
        filesValidator.validateForWriting(outputFile);

        List<String> sourceLines = Collections.singletonList(fileProcessor.readFile(inputFile));
        for (String str : sourceLines) {
            String bruteForcedText = BruteForce.bruteForce(str);
            fileProcessor.writeToFile(outputFile, bruteForcedText);
        }
    }
}
