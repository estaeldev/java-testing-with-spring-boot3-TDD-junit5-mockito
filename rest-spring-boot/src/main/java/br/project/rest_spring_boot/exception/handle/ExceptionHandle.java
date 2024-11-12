package br.project.rest_spring_boot.exception.handle;

import java.security.InvalidParameterException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.project.rest_spring_boot.exception.ExceptionResponse;

@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception exception, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(), 
            exception.getMessage(), 
            request.getDescription(false), 
            HttpStatus.INTERNAL_SERVER_ERROR
        );

        return ResponseEntity.status(exceptionResponse.getCode()).body(exceptionResponse);
    }

    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidParameterException(Exception exception, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(), 
            exception.getMessage(), 
            request.getDescription(false), 
            HttpStatus.BAD_REQUEST
        );

        return ResponseEntity.status(exceptionResponse.getCode()).body(exceptionResponse);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> handleIllegalArgumentException(Exception exception, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(), 
            exception.getMessage(), 
            request.getDescription(false), 
            HttpStatus.NOT_FOUND
        );

        return ResponseEntity.status(exceptionResponse.getCode()).body(exceptionResponse);
    }

    
}
