package ru.javarush.timonova.cryptoanalyzer.view;

import ru.javarush.timonova.cryptoanalyzer.Entity.Result;

public interface View {
    String[] getParameters();
    void printResults(Result result);
}
