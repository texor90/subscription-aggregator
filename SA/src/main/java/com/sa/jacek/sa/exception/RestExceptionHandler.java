package com.sa.jacek.sa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(ResourceNotFoundException ex) {
        CustomError apiError = new CustomError(ex);
        apiError.setMessage(ex.getMessage());
        apiError.setCode(ex.getErrorCode());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IdMismatchException.class)
    protected ResponseEntity<Object> handleEntityNotFound(IdMismatchException ex) {
        CustomError apiError = new CustomError(ex);
        apiError.setCode(ex.getErrorCode());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}
