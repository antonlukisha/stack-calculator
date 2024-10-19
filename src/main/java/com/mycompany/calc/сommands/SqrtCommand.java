package com.mycompany.calc.сommands;

import com.mycompany.calc.exceptions.AriphmeticException;
import com.mycompany.calc.exceptions.CalculatorException;
import com.mycompany.calc.exceptions.IncorrectSqrtValueExpressionException;
import com.mycompany.calc.exceptions.StackExpressionException;
import com.mycompany.calc.factory.ExecutionContext;
import java.util.Stack;

public class SqrtCommand implements Command {
    private final Stack<Double> stack;
    private final ExecutionContext context;

    public SqrtCommand(ExecutionContext context) {
        this.context = context;
        this.stack = context.getStack();
    }

    @Override
    public String execute(String[] args) throws CalculatorException, AriphmeticException {
        if (stack.isEmpty()) {
            throw new StackExpressionException();
        }
        double operand = Double.parseDouble((new PopCommand(context).execute()).split("\\s+")[1]);
        if (operand < 0) {
            throw new IncorrectSqrtValueExpressionException();
        }
        double result = Math.sqrt(operand);
        new PushCommand(context).execute(String.valueOf(result));
        return "Performed square root: sqrt(" + operand + ") = " + result;
    }
}


