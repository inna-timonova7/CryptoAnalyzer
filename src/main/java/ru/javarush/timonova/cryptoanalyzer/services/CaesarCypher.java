package ru.javarush.timonova.cryptoanalyzer.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.javarush.timonova.cryptoanalyzer.constants.CypherAlphabet;

@Data
@AllArgsConstructor

// TODO remove class after checking the app working
public class CaesarCypher {
    public static String encryptText(String textForEncryption, int key) {
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
    }

    public static String decryptText(String textForDecryption, int key) {
        StringBuilder decryptedText = new StringBuilder();

        textForDecryption = textForDecryption.toLowerCase();

        for (char symbol : textForDecryption.toCharArray()) {
            int index = indexOf(symbol);
            if (index != -1) {
                int indexToShift = (index - key + CypherAlphabet.CYPHER_ALPHABET.length) % CypherAlphabet.CYPHER_ALPHABET.length;
                decryptedText.append(CypherAlphabet.CYPHER_ALPHABET[indexToShift]);
            } else {
                decryptedText.append(symbol);
            }
        }
        return decryptedText.toString();
    }

    private static int indexOf(char symbol) {
        for (int i = 0; i < CypherAlphabet.CYPHER_ALPHABET.length; i++) {
            if (CypherAlphabet.CYPHER_ALPHABET[i] == symbol) {
                return i;
            }
        }
        return -1;
    }

//    public static void main(String[] args) {
//        String text1 = "Парус";
//        String text2 = "Кран";
//        System.out.println(text1);
//        System.out.println(encryptText(text1, 2));
//        //свтху
//        System.out.println(text2);
//        System.out.println(encryptText(text2, 3));
//        //нугр
//    }
}

