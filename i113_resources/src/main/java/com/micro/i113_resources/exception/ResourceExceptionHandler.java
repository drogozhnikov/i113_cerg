package com.micro.i113_resources.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = {ResourceException.class})
    protected ResponseEntity<Object> handleConflict(ResourceException ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.clearContentHeaders();
        return handleExceptionInternal(ex, ex.getMessage(), headers, ex.getStatus(), request);
    }

//    @ExceptionHandler(value = {PSQLException.class})
//    protected ResponseEntity<Object> handleConflict(PSQLException ex, WebRequest request) {
//        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
//    }
}
