package com.example.demo.presentation;

import com.example.demo.domain.exception.ErrorResult;
import com.example.demo.domain.exception.ManyDuplicationException;
import com.example.demo.domain.exception.NewUrlNotFoundException;
import com.example.demo.domain.exception.UrlFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NewUrlNotFoundException.class)
    public ResponseEntity<ErrorResult> handleNotFoundException(NewUrlNotFoundException e) {
        log.info("NewUrlNotFoundException ex", e);
        ErrorResult errorResult = new ErrorResult("NewUrlNotFoundException", e.getMessage());
        return new ResponseEntity<>(errorResult, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ManyDuplicationException.class)
    public ResponseEntity<ErrorResult> handleFormatException(ManyDuplicationException e) {
        log.info("ManyDuplicationException ex", e);
        ErrorResult errorResult = new ErrorResult("ManyDuplicationException", e.getMessage());
        return new ResponseEntity(errorResult, HttpStatus.REQUEST_TIMEOUT);
    }

    @ExceptionHandler(UrlFormatException.class)
    public ResponseEntity<ErrorResult> handleFormatException(UrlFormatException e) {
        log.info("UrlFormatException ex", e);
        ErrorResult errorResult = new ErrorResult("UrlFormatException", e.getMessage());
        return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResult> handleAllException(Exception e) {
        log.info("handleAllException ex", e);
        ErrorResult errorResult = new ErrorResult("handleAllException", e.getMessage());
        return new ResponseEntity<>(errorResult, HttpStatus.INTERNAL_SERVER_ERROR);
    }

};
