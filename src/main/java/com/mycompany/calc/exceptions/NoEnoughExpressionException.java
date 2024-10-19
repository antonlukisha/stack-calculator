package com.mycompany.calc.exceptions;

public class NoEnoughExpressionException extends CalculatorException {
    public NoEnoughExpressionException() {
        super("Not enough operands for addition");
    }
}

