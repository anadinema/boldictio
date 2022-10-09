package me.anadinema.project.boldictio.exception;

import lombok.Data;

@Data
public class ApiClientException extends Exception {
    private String action;
    private String inputWord;

    public ApiClientException(String message, String inputWord, String action) {
        super(message);
        this.action = action;
        this.inputWord = inputWord;
    }

    public ApiClientException(ApiClientException exception) {
        super(exception.getMessage());
        this.action=exception.getAction();
        this.inputWord=exception.getInputWord();
    }
}
