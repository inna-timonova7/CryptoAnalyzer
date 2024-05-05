package ru.javarush.timonova.cryptoanalyzer.services;

import ru.javarush.timonova.cryptoanalyzer.Entity.Result;
import ru.javarush.timonova.cryptoanalyzer.constants.CypherAlphabet;
import ru.javarush.timonova.cryptoanalyzer.exceptions.ExceptionsInApplication;
import ru.javarush.timonova.cryptoanalyzer.repository.ResultCode;

public class BruteForce implements Function{
    @Override
    public Result perform(String[] parameters) {
        try{
            // TODO needs to be done
        } catch (Exception e) {
            return new Result(ResultCode.ERROR, new ExceptionsInApplication("Brute Force process finished with exception", e));
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
