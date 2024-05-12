package ru.javarush.timonova.cryptoanalyzer.controller;

import ru.javarush.timonova.cryptoanalyzer.constants.ResultPath;
import ru.javarush.timonova.cryptoanalyzer.files.FileProcessor;
import ru.javarush.timonova.cryptoanalyzer.guiView.GUIView;
import ru.javarush.timonova.cryptoanalyzer.services.BruteForce;
import ru.javarush.timonova.cryptoanalyzer.services.Decode;
import ru.javarush.timonova.cryptoanalyzer.services.Encode;

import java.util.*;

public class CaesarCypherCoder {
    // TODO fix FileNotFoundException OR AccessDeniedException
    // TODO Make app more OOP like
    public CaesarCypherCoder(FileProcessor fileProcessor) {
        this.fileProcessor = fileProcessor;
    }

    private FileProcessor fileProcessor;
    public void performOperation() {
        if (GUIView.ENCRYPT.isSelected()){
            performEncryption(GUIView.getFileSource(), ResultPath.RESULT_FOLDER, GUIView.getKey());
        } else if (GUIView.DECRYPT.isSelected()) {

            performDecryption(GUIView.getFileSource(), ResultPath.RESULT_FOLDER, GUIView.getKey());
        } else if (GUIView.BRUTE_FORCE.isSelected()) {

            performBruteForcing(GUIView.getFileSource(), ResultPath.RESULT_FOLDER);
        } else if (GUIView.EXIT.isSelected()) {
            System.out.println("Buy! Hope to see you soon.");
        }
    }

    public void performEncryption(String inputFile, String outputFile, int key) {
        List<String> sourceLines = Collections.singletonList(fileProcessor.readFile(inputFile));
        for (String str : sourceLines) {
            String encryptedLine = Encode.encrypt(str, key);
            fileProcessor.writeToFile(outputFile, encryptedLine);
        }
    }

    private void performDecryption(String inputFile, String outputFile, int key) {
        List<String> sourceLines = Collections.singletonList(fileProcessor.readFile(inputFile));
        for (String str : sourceLines) {
            String decryptedLine = Decode.decrypt(str, key);
            fileProcessor.writeToFile(outputFile, decryptedLine);
        }
    }

    private void performBruteForcing(String inputFile, String outputFile) {
        List<String> sourceLines = Collections.singletonList(fileProcessor.readFile(inputFile));
        for (String str : sourceLines) {
            String bruteForcedText = BruteForce.bruteForce(str);
            fileProcessor.writeToFile(outputFile, bruteForcedText);
        }
    }
}
