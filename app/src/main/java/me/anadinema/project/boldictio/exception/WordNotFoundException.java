package me.anadinema.project.boldictio.exception;

import lombok.Data;

@Data
public class WordNotFoundException extends Exception {

    private String action;
    private String inputWord;

    public WordNotFoundException(String message, String inputWord, String action) {
        super(message);
        this.action = action;
        this.inputWord = inputWord;
    }

    public WordNotFoundException(WordNotFoundException exception) {
        super(exception.getMessage());
        this.action=exception.getAction();
        this.inputWord=exception.getInputWord();
    }
}
