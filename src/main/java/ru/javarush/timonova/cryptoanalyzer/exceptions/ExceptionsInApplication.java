package ru.javarush.timonova.cryptoanalyzer.exceptions;

public class ExceptionsInApplication extends RuntimeException {

    String message;
    public ExceptionsInApplication() {
    }

    public ExceptionsInApplication(String message) {
        this.message = message;
    }

    public ExceptionsInApplication(String message, Throwable cause) {
        super(cause);
        this.message = message;
    }

    public ExceptionsInApplication(Throwable cause) {
        super(cause);
    }

    public String getMessage() {
        return this.message;
    }
}
