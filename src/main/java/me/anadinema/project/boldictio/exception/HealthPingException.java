package me.anadinema.project.boldictio.exception;

import lombok.Data;

@Data
public class HealthPingException extends Exception {

    private String action;

    public HealthPingException(String message, String action) {
        super(message);
        this.action = action;
    }

    public HealthPingException(HealthPingException exception) {
        super(exception.getMessage());
        this.action=exception.getAction();
    }
}
