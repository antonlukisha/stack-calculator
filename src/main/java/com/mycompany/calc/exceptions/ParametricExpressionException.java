package com.mycompany.calc.exceptions;

public class ParametricExpressionException extends CalculatorException {
    public ParametricExpressionException() {
        super("Incorrect value of parameter");
    }
}
