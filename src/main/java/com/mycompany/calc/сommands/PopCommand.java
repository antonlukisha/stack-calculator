package com.mycompany.calc.сommands;

import com.mycompany.calc.exceptions.CalculatorException;
import com.mycompany.calc.exceptions.StackExpressionException;
import com.mycompany.calc.factory.ExecutionContext;
import java.util.Stack;

public class PopCommand implements Command {
    private final Stack<Double> stack;

    public PopCommand(ExecutionContext context) {
        this.stack = context.getStack();
    }

    @Override
    public String execute(String... args) throws CalculatorException {
        if (stack.isEmpty()) {
            throw new StackExpressionException();
        }
        return "Poped: " + stack.pop();
    }
}