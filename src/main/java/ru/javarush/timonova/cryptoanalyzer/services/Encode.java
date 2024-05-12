package ru.javarush.timonova.cryptoanalyzer.services;

import ru.javarush.timonova.cryptoanalyzer.constants.CypherAlphabet;
import ru.javarush.timonova.cryptoanalyzer.exceptions.ExceptionsInApplication;

public class Encode {

    public static String encrypt(String textForEncryption, int key) {
        try {
            StringBuilder encryptedText = new StringBuilder();
            textForEncryption = textForEncryption.toLowerCase();
            for (char symbol : textForEncryption.toCharArray()) {
                int index = indexOf(symbol);
                if (index != -1) {
                    int indexToShift = (index + key) % CypherAlphabet.CYPHER_ALPHABET.length;
                    encryptedText.append(CypherAlphabet.CYPHER_ALPHABET[indexToShift]);
                } else {
                    encryptedText.append(symbol);
                }
            }
            return encryptedText.toString();
        } catch (Exception e) {
            throw new ExceptionsInApplication("Encode process finished with an exception", e);
        }
    }

    private static int indexOf(char symbol) {
        for (int i = 0; i < CypherAlphabet.CYPHER_ALPHABET.length; i++) {
            if (CypherAlphabet.CYPHER_ALPHABET[i] == symbol) {
                return i;
            }
        }
        return -1;
    }
}
