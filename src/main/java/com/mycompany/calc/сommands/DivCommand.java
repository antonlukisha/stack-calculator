package com.mycompany.calc.сommands;

import com.mycompany.calc.exceptions.AriphmeticException;
import com.mycompany.calc.exceptions.CalculatorException;
import com.mycompany.calc.exceptions.NoEnoughExpressionException;
import com.mycompany.calc.exceptions.NullDivExpressionException;
import com.mycompany.calc.factory.ExecutionContext;
import java.util.Stack;

public class DivCommand implements Command {
    private final ExecutionContext context;
    private final Stack<Double> stack;

    public DivCommand(ExecutionContext context) {
        this.context = context;
        this.stack = context.getStack();
    }

    @Override
    public String execute(String... args) throws CalculatorException, AriphmeticException {
        if (stack.size() < 2) {
            throw new NoEnoughExpressionException();
        }
        double operand2 = Double.parseDouble((new PopCommand(context).execute()).split("\\s+")[1]);
        double operand1 = Double.parseDouble((new PopCommand(context).execute()).split("\\s+")[1]);
        if (operand2 == 0) {
            throw new NullDivExpressionException();
        }
        double result = operand1 / operand2;
        new PushCommand(context).execute(String.valueOf(result));
        return "Performed addition: " + operand1 + " / " + operand2 + " = " + result;
    }
}
