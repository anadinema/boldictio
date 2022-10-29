package me.anadinema.project.boldictio.exception.advice;

import lombok.extern.slf4j.Slf4j;
import me.anadinema.project.boldictio.entity.ApiClientErrorResponse;
import me.anadinema.project.boldictio.exception.ApiClientException;
import me.anadinema.project.boldictio.exception.HealthPingException;
import me.anadinema.project.boldictio.exception.WordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;

@Slf4j
@ControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler(ApiClientException.class)
    public ResponseEntity<ApiClientErrorResponse> handleApiClientIssues(ApiClientException exception) {
        ApiClientErrorResponse errorResponse = new ApiClientErrorResponse();
        errorResponse.setWord(exception.getInputWord());
        errorResponse.setReason(exception.getMessage());
        errorResponse.setAction(exception.getAction());
        errorResponse.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity<ApiClientErrorResponse>(errorResponse, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(WordNotFoundException.class)
    public ResponseEntity<ApiClientErrorResponse> handleMissingWord(WordNotFoundException exception) {
        ApiClientErrorResponse errorResponse = new ApiClientErrorResponse();
        errorResponse.setWord(exception.getInputWord());
        errorResponse.setReason(exception.getMessage());
        errorResponse.setAction(exception.getAction());
        errorResponse.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity<ApiClientErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HealthPingException.class)
    public ResponseEntity<ApiClientErrorResponse> handleHealthException(HealthPingException exception) {
        ApiClientErrorResponse errorResponse = new ApiClientErrorResponse();
        errorResponse.setAction(exception.getAction());
        errorResponse.setReason(exception.getMessage());
        errorResponse.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity<ApiClientErrorResponse>(errorResponse, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiClientErrorResponse> handleRuntimeException(RuntimeException exception) {
        ApiClientErrorResponse errorResponse = new ApiClientErrorResponse();
        errorResponse.setAction("Runtime exception, please try again after sometime");
        errorResponse.setReason(exception.getMessage());
        errorResponse.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity<ApiClientErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiClientErrorResponse> handleGenericException(Exception exception) {
        ApiClientErrorResponse errorResponse = new ApiClientErrorResponse();
        errorResponse.setAction("Check application logs to identify the error!");
        errorResponse.setReason(exception.getMessage());
        errorResponse.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity<ApiClientErrorResponse>(errorResponse, HttpStatus.NOT_IMPLEMENTED);
    }
}
