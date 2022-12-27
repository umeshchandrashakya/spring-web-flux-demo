package com.capgemini.webfluxdemo.exceptionhandler;

import com.capgemini.webfluxdemo.dto.InputFailedValidationResponse;
import com.capgemini.webfluxdemo.exception.InputValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InputValidationHandler {
    @ExceptionHandler(InputValidationException.class)
    public ResponseEntity<InputFailedValidationResponse> handleException(InputValidationException exception){
         InputFailedValidationResponse response = new InputFailedValidationResponse();
         response.setErrorCode(exception.getErrorCode());
         response.setMessage(exception.getMessage());
         response.setInput(exception.getINPUT());
         return ResponseEntity.badRequest().body(response);
    }
}
