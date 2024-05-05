package ru.javarush.timonova.cryptoanalyzer.exceptions;

public class ExceptionsInApplication extends RuntimeException {
    public ExceptionsInApplication() {
    }

    public ExceptionsInApplication(String message) {
        super(message);
    }

    public ExceptionsInApplication(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionsInApplication(Throwable cause) {
        super(cause);
    }
}
