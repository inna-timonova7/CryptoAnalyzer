package ru.javarush.timonova.cryptoanalyzer.services;

import ru.javarush.timonova.cryptoanalyzer.Entity.Result;
import ru.javarush.timonova.cryptoanalyzer.constants.CypherAlphabet;
import ru.javarush.timonova.cryptoanalyzer.exceptions.ExceptionsInApplication;
import ru.javarush.timonova.cryptoanalyzer.repository.ResultCode;

public class Encode implements Function {
    @Override
    public Result perform(String[] parameters) {
        try{
            String textForEncryption = parameters[0];
            int key = Integer.parseInt(parameters[1]);
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
            encryptedText.toString();
            // TODO prove it works
        } catch (Exception e) {
            return new Result(ResultCode.ERROR, new ExceptionsInApplication("Encode process finished with an exception", e));
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
