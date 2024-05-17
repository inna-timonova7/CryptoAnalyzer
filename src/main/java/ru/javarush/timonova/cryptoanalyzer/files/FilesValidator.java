package ru.javarush.timonova.cryptoanalyzer.files;

import ru.javarush.timonova.cryptoanalyzer.exceptions.ExceptionInFileProcessing;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.List;

public class FilesValidator {

    public static final List<String> FILES_NOT_SUPPORTED = List.of(".bash_profile", "hosts", ".bash_history", "proc");

    public void validateReadingFile(String file) {
        Path path = validateFilePath(file);
        if (!Files.exists(path)) {
            throw new ExceptionInFileProcessing("File " + path + " does not exist");
        }
        if (Files.isDirectory(path)) {
            throw new ExceptionInFileProcessing(path + " is not a file, but a directory");
        }
        if (!Files.isReadable(path)) {
            throw new ExceptionInFileProcessing("Not enough permission to read from the file" + path);
        }
    }

    public void validateForWriting(String file) {
        Path path = validateFilePath(file);
        if (Files.isDirectory(path)) {
            throw new ExceptionInFileProcessing(path + " is not a file, but a directory");
        }
    }

    private Path validateFilePath(String file) {
        for (String str : file.split("\"", 1)) {
            if (FILES_NOT_SUPPORTED.contains(str)) {
                throw new ExceptionInFileProcessing("The file type with " + str + " is not supported");
            }
        }
        try {
            Path path = Path.of(file);
            return path;
        } catch (InvalidPathException e) {
            throw new ExceptionInFileProcessing("Invalid path." + e.getMessage());
        }
    }
}
