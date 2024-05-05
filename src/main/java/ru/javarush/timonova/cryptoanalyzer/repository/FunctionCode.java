package ru.javarush.timonova.cryptoanalyzer.repository;

import ru.javarush.timonova.cryptoanalyzer.services.BruteForce;
import ru.javarush.timonova.cryptoanalyzer.services.Decode;
import ru.javarush.timonova.cryptoanalyzer.services.Encode;
import ru.javarush.timonova.cryptoanalyzer.services.Function;
import ru.javarush.timonova.cryptoanalyzer.services.UnsupportedFunction;

public enum FunctionCode {

    ENCODE(new Encode()),
    DECODE (new Decode()),

    BRUTE_FORCE (new BruteForce()),
    UNSUPPORTED_FUNCTION(new UnsupportedFunction());
    private Function function;

    FunctionCode(Function function) {
        this.function = function;
    }

    public Function getFunction() {
        return function;
    }
}
