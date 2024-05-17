package ru.javarush.timonova.cryptoanalyzer.controller;

import ru.javarush.timonova.cryptoanalyzer.constants.ResultPath;
import ru.javarush.timonova.cryptoanalyzer.guiView.GUIView;

import java.util.Random;

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
            coder.performEncryption(GUIView.getFileSource(), ResultPath.RESULT_FOLDER + setRandomFilenameEncryption(), GUIView.getKeyEn());

        } else if (GUIView.DECRYPT.isSelected()) {
            coder.performDecryption(GUIView.getFileSource(), ResultPath.RESULT_FOLDER + setRandomFilenameDecryption(), GUIView.getKeyDe());

        } else if (GUIView.BRUTE_FORCE.isSelected()) {
            coder.performBruteForcing(GUIView.getFileSource(), ResultPath.RESULT_FOLDER + setRandomFilenameBruteForce());

        } else if (GUIView.EXIT.isSelected()) {
            System.out.println("Buy! Hope to see you soon.");
        }
    }

    private String setRandomFilenameEncryption() {
        return "encryptedFile" + new Random().nextInt(3) + " .txt";
    }

    private String setRandomFilenameDecryption() {
        return "decryptedFile" + new Random().nextInt(3) + " .txt";
    }

    private String setRandomFilenameBruteForce() {
        return "bruteForcedFile" + new Random().nextInt(3) + " .txt";
    }
}
