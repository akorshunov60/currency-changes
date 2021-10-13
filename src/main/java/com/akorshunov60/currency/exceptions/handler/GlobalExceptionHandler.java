package com.akorshunov60.currency.exceptions.handler;

import com.akorshunov60.currency.exceptions.response.ErrorResponse;
import com.akorshunov60.currency.exceptions.BadBaseException;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public GlobalExceptionHandler() {
        super();
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorResponse> feignException(FeignException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(BadBaseException.class)
    public ResponseEntity<ErrorResponse> badBaseException(BadBaseException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> otherException(RuntimeException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
