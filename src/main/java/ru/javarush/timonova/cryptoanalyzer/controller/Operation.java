package ru.javarush.timonova.cryptoanalyzer.controller;

import ru.javarush.timonova.cryptoanalyzer.constants.ResultPath;
import ru.javarush.timonova.cryptoanalyzer.guiView.GUIView;

import java.util.*;

public class Operation {

    private static final int NUMBER = 3;

    private CaesarCypherCoder coder;
    private GUIView guiView;

    public Operation() {
        this.coder = new CaesarCypherCoder();
        this.guiView = new GUIView();
    }

    public void performOperation() {

        if (GUIView.ENCRYPT.isSelected()) {
            coder.performEncryption(GUIView.getFileSource(), ResultPath.RESULT_FOLDER + getRandomFilenameEncryption(), GUIView.getKey());

        } else if (GUIView.DECRYPT.isSelected()) {
            coder.performDecryption(GUIView.getFileSource(), ResultPath.RESULT_FOLDER + getRandomFilenameDecryption(), GUIView.getKey());

        } else if (GUIView.BRUTE_FORCE.isSelected()) {
            coder.performBruteForcing(GUIView.getFileSource(), ResultPath.RESULT_FOLDER + getRandomFilenameBruteForce());
        } else if (GUIView.EXIT.isSelected()) {
            System.out.println("Buy! Hope to see you soon.");
        }
    }

    private String getRandomFilenameEncryption() {
        return "encryptedFile" + new Random().nextInt(3) + " .txt";
    }

    private String getRandomFilenameDecryption() {
        return "decryptedFile" + new Random().nextInt(3) + " .txt";
    }

    private String getRandomFilenameBruteForce() {
        return "bruteForcedFile" + new Random().nextInt(3) + " .txt";
    }
}
