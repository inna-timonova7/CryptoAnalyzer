package ru.javarush.timonova.cryptoanalyzer.view;

import ru.javarush.timonova.cryptoanalyzer.Entity.Result;

import static ru.javarush.timonova.cryptoanalyzer.constants.AppCompletedConstant.EXCEPTION;
import static ru.javarush.timonova.cryptoanalyzer.constants.AppCompletedConstant.SUCCESS;

public class ConsoleView implements View {
    @Override
    public String[] getParameters() {
        // TODO complete getParameters method in ConsoleView
        return new String[0];
    }

    @Override
    public void printResults(Result result) {
        switch (result.getResultCode()) {
            case OK -> System.out.println(SUCCESS);
            case ERROR -> System.out.println(EXCEPTION + result.getExceptionsInApplication().getMessage());
        }
    }
}
