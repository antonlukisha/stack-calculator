package com.mycompany.calc.exceptions;

public class NumericExpressionException extends CalculatorException {
    public NumericExpressionException() {
        super("Incorrect value of parameter");
    }
}
