package ru.javarush.timonova.cryptoanalyzer.services;

import ru.javarush.timonova.cryptoanalyzer.Entity.Result;
import ru.javarush.timonova.cryptoanalyzer.exceptions.ExceptionsInApplication;
import ru.javarush.timonova.cryptoanalyzer.repository.ResultCode;

public class UnsupportedFunction implements Function {
    @Override
    public Result perform(String[] parameters) {
        try{
            // TODO place here coder method + put code - ok or error
        } catch (Exception e) {
            return new Result(ResultCode.ERROR, new ExceptionsInApplication("Decode process finished with exception", e));
        }
        return new Result(ResultCode.OK);
    }
}
