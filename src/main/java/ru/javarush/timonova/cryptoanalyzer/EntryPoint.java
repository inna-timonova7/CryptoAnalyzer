package ru.javarush.timonova.cryptoanalyzer;

import ru.javarush.timonova.cryptoanalyzer.Entity.Result;
import ru.javarush.timonova.cryptoanalyzer.app.Application;
import ru.javarush.timonova.cryptoanalyzer.mainController.MainController;
import ru.javarush.timonova.cryptoanalyzer.view.ConsoleView;
import ru.javarush.timonova.cryptoanalyzer.view.View;

public class EntryPoint {
    public static void main(String[] args) {

        View view = new ConsoleView(); // || GUI view || WEB view || Mobile view
        MainController mainController = new MainController(view);
        Application application = new Application(mainController);

        // TODO ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0 - needs to be fixed
        Result result = application.run();
        application.printResult(result);
    }
}