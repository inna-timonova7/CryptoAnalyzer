package ru.javarush.timonova.cryptoanalyzer.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.javarush.timonova.cryptoanalyzer.constants.ResultCode;
import ru.javarush.timonova.cryptoanalyzer.exceptions.ExceptionsInApplication;

@Data
@AllArgsConstructor
public class Result {
    private ResultCode resultCode;
    private ExceptionsInApplication exceptionsInApplication;

    public Result(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
