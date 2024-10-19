package com.mycompany.calc.сommands;

import com.mycompany.calc.exceptions.CalculatorException;
import com.mycompany.calc.exceptions.NoEnoughExpressionException;
import com.mycompany.calc.exceptions.NumericExpressionException;
import com.mycompany.calc.factory.ExecutionContext;
import java.util.Map;
import java.util.Stack;

public class PushCommand implements Command {
    private final Map<String, Double> parameters;
    private final Stack<Double> stack;

    public PushCommand(ExecutionContext context) {
        this.stack = context.getStack();
        this.parameters = context.getParameters();
    }

    @Override
    public String execute(String... args) throws CalculatorException {
        if (args.length < 1) {
            throw new NoEnoughExpressionException();
        }
        String value = args[0];
        if (parameters.containsKey(value)) {
            stack.push(parameters.get(value));
            return "Pushed parameter value: " + parameters.get(value);
        } else {
            if (!isInteger(value) && !isDouble(value)) {
                throw new NumericExpressionException();
            }
            double doubleValue = Double.parseDouble(value);
            stack.push(doubleValue);
            return "Pushed double value: " + doubleValue;
        }
    }
    
    public static boolean isInteger(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    public static boolean isDouble(String str) {
        try {
            Double.valueOf(str);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}

