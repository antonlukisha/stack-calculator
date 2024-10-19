package com.mycompany.calc.exceptions;

public class NullDivExpressionException extends AriphmeticException {
    public NullDivExpressionException() {
        super("Cannot divide by zero");
    }
}

