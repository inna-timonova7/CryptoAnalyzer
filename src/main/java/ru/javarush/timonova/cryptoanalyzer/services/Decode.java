package ru.javarush.timonova.cryptoanalyzer.services;

import ru.javarush.timonova.cryptoanalyzer.Entity.Result;
import ru.javarush.timonova.cryptoanalyzer.constants.CypherAlphabet;
import ru.javarush.timonova.cryptoanalyzer.exceptions.ExceptionsInApplication;
import ru.javarush.timonova.cryptoanalyzer.repository.ResultCode;

public class Decode implements Function {
    @Override
    public Result perform(String[] parameters) {
        try{
            String textForDecryption = parameters[0];
            int key = Integer.parseInt(parameters[1]);
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
                decryptedText.toString();
            // TODO prove it works
        } catch (Exception e) {
            return new Result(ResultCode.ERROR, new ExceptionsInApplication("Decode process finished with exception", e));
        }
        return new Result(ResultCode.OK);
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
