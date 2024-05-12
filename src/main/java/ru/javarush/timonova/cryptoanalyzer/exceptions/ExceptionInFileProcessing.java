package ru.javarush.timonova.cryptoanalyzer.exceptions;

public class ExceptionInFileProcessing extends RuntimeException {
    String message;

    public ExceptionInFileProcessing() {
    }

    public ExceptionInFileProcessing(String message) {
        this.message = message;
    }

    public ExceptionInFileProcessing(String message, Throwable cause) {
        super(cause);
        this.message = message;
    }

    public ExceptionInFileProcessing(Throwable cause) {
        super(cause);
    }

    public String getMessage() {
        return this.message;
    }
}
