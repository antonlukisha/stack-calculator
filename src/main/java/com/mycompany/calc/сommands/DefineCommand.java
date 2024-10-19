package com.mycompany.calc.сommands;

import com.mycompany.calc.exceptions.CalculatorException;
import com.mycompany.calc.exceptions.NoEnoughExpressionException;
import com.mycompany.calc.exceptions.ParametricExpressionException;
import com.mycompany.calc.factory.ExecutionContext;
import java.util.Map;

public class DefineCommand implements Command {
    private final Map<String, Double> parameters;

    public DefineCommand(ExecutionContext context) {
        this.parameters = context.getParameters();
    }

    @Override
    public String execute(String... args) throws CalculatorException {
        if (args.length < 2) {
            throw new NoEnoughExpressionException();
        }
        String parameterName = args[0];
        double value = Double.parseDouble(args[1]);
        if (isCorrectParamenter(parameterName)) {
            throw new ParametricExpressionException();
        }
        parameters.put(parameterName, value);
        return "Defined parameter: " + parameterName + " = " + value;
    }
    
    private boolean isCorrectParamenter(String str) {
        for (char symbol : str.toCharArray()) {
            if (Character.isAlphabetic(symbol)) {
                return false;
            }
        }
        return true;
    }
}
