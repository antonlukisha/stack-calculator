package com.mycompany.calc.сommands;

import com.mycompany.calc.exceptions.AriphmeticException;
import com.mycompany.calc.exceptions.CalculatorException;

public interface Command {

    public abstract String execute(String... args) throws CalculatorException, AriphmeticException;
}

