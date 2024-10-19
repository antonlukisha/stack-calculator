package com.mycompany.calc.factory;

import java.util.Map;
import java.util.Stack;

public class ExecutionContext {
    private final Stack<Double> stack;
    private final Map<String, Double> parameters;

    public ExecutionContext(Stack<Double> stack, Map<String, Double> parameters) {
        this.stack = stack;
        this.parameters = parameters;
    }

    public Stack<Double> getStack() {
        return stack;
    }

    public Map<String, Double> getParameters() {
        return parameters;
    }
}
