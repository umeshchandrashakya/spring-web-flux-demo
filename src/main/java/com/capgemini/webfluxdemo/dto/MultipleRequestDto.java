package com.capgemini.webfluxdemo.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MultipleRequestDto {
    private int firstNumber;
    private int secondNumber;

    public MultipleRequestDto(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }
}
