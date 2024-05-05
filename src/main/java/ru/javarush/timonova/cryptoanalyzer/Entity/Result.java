package ru.javarush.timonova.cryptoanalyzer.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.javarush.timonova.cryptoanalyzer.exceptions.ExceptionsInApplication;
import ru.javarush.timonova.cryptoanalyzer.repository.ResultCode;

@Data
@AllArgsConstructor
public class Result {
    private ResultCode resultCode;
    private ExceptionsInApplication exceptionsInApplication;

    public Result(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
