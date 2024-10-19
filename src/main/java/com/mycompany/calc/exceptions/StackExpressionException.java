package com.mycompany.calc.exceptions;

public class StackExpressionException extends CalculatorException {
    public StackExpressionException() {
        super("Impossible get value from stack");
    }
}
