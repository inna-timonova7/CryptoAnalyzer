package ru.javarush.timonova.cryptoanalyzer.services;

import ru.javarush.timonova.cryptoanalyzer.constants.CypherAlphabet;
import ru.javarush.timonova.cryptoanalyzer.exceptions.ExceptionsInApplication;

public class Decrypt {
    public static String decrypt(String textForDecryption, int key) {
        try {
            StringBuilder decryptedText = new StringBuilder();

            textForDecryption = textForDecryption.toLowerCase();

            for (char symbol : textForDecryption.toCharArray()) {
                int index = indexOf(symbol);
                if (index != -1) {
                    int indexToShift = (index - key + CypherAlphabet.ALPHABET.size()) % CypherAlphabet.ALPHABET.size();
                    decryptedText.append(CypherAlphabet.ALPHABET.get(indexToShift));
                } else {
                    decryptedText.append(symbol);
                }
            }
            return decryptedText.toString();
        } catch (Exception e) {
            throw new ExceptionsInApplication("Decode process finished with exception", e);
        }
    }

    private static int indexOf(char symbol) {
        for (int i = 0; i < CypherAlphabet.ALPHABET.size(); i++) {
            if (CypherAlphabet.ALPHABET.get(i) == symbol) {
                return i;
            }
        }
        return -1;
    }
}
