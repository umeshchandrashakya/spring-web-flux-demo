package com.capgemini.webfluxdemo.exception;

public class InputValidationException extends RuntimeException{
private static final String MSG = "Allowed range is 10 to 20";
private static final int ERROR_CODE = 100;
private final int INPUT;

    public int getINPUT() {
        return INPUT;
    }

    public  int getErrorCode(){
        return ERROR_CODE;
    }

    public InputValidationException(int input) {
        super(MSG);
        INPUT = input;
    }
}
