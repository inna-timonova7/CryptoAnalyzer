//package ru.javarush.timonova.cryptoanalyzer.app;
//
//import ru.javarush.timonova.cryptoanalyzer.Entity.Result;
//import ru.javarush.timonova.cryptoanalyzer.guiView.GUIView;
//import ru.javarush.timonova.cryptoanalyzer.mainController.MainController;
//import ru.javarush.timonova.cryptoanalyzer.repository.FunctionCode;
//import ru.javarush.timonova.cryptoanalyzer.services.Function;
//
//import static ru.javarush.timonova.cryptoanalyzer.constants.FunctionCodeConstants.BRUTE_FORCE;
//import static ru.javarush.timonova.cryptoanalyzer.constants.FunctionCodeConstants.DECODE;
//import static ru.javarush.timonova.cryptoanalyzer.constants.FunctionCodeConstants.ENCODE;
//import static ru.javarush.timonova.cryptoanalyzer.constants.FunctionCodeConstants.UNSUPPORTED_FUNCTION;
//
//public class Application {
//    private final MainController mainController;
//    public Application(MainController mainController) {
//        this.mainController = mainController;
//    }
//
//    public Result run(){
//        String[] parameters = mainController.getView().getParameters();
//        String applicationMode = parameters[0];
//        Function function = getFunction(applicationMode);
//        return function.perform(parameters);
//    }
//    public void printResult(Result result) {
//        mainController.getView().printResults(result);
//    }
//
//    private Function getFunction(String applicationMode) {
//        return switch (applicationMode) {
//            case "1" -> FunctionCode.valueOf(ENCODE).getFunction();
//            case "2" -> FunctionCode.valueOf(DECODE).getFunction();
//            case "3" -> FunctionCode.valueOf(BRUTE_FORCE).getFunction();
//            default -> FunctionCode.valueOf(UNSUPPORTED_FUNCTION).getFunction();
//        };
//    }
//
////    private final GUIView guiView;
////
////
////    public Application(GUIView guiView) {
////        this.guiView = guiView;
////    }
////
////    public Result run() {
////        String[] parameters = guiView.g
////    }
//}
