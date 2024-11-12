package br.project.rest_spring_boot.exception;

import java.io.Serializable;
import java.util.Date;

import org.springframework.http.HttpStatus;

public class ExceptionResponse implements Serializable {

    private final Date timestamp;
    private final String message;
    private final String details;
    private final HttpStatus code;

    public ExceptionResponse(Date timestamp, String message, String details, HttpStatus code) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.code = code;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public HttpStatus getCode() {
        return code;
    }
    
}
