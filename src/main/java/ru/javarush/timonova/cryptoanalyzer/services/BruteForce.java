package ru.javarush.timonova.cryptoanalyzer.services;

import ru.javarush.timonova.cryptoanalyzer.constants.CypherAlphabet;
import ru.javarush.timonova.cryptoanalyzer.exceptions.ExceptionsInApplication;

import java.util.*;

public class BruteForce {
    public static String bruteForce(String textForDecryption) {
        List<char[]> alphabetList = List.of(CypherAlphabet.CYPHER_ALPHABET);
        String[] plainText = new String[CypherAlphabet.CYPHER_ALPHABET.length];
        try {
            char[] message = textForDecryption.toLowerCase().toCharArray();
            for (int key = 1; key < CypherAlphabet.CYPHER_ALPHABET.length; key++) {
                char[] decodedText = new char[message.length];
                for (int i = 0; i < message.length; i++) {
                    if (message[i] != ' ') {
                        decodedText[i] = CypherAlphabet.CYPHER_ALPHABET[(alphabetList.indexOf(message[i]) + key) % CypherAlphabet.CYPHER_ALPHABET.length];
                    } else {
                        decodedText[i] = ' ';
                    }
                }
                plainText[key] = String.valueOf(decodedText);
            }
        } catch (Exception e) {
            throw new ExceptionsInApplication("Brute Force process finished with exception", e);
        }
        return Arrays.toString(plainText);
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
