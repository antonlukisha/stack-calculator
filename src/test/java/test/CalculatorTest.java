package test;

import com.mycompany.calc.сalculator.Calculator;
import com.mycompany.calc.сommands.DefineCommand;
import com.mycompany.calc.сommands.PrintCommand;
import com.mycompany.calc.exceptions.AriphmeticException;
import com.mycompany.calc.exceptions.CalculatorException;
import com.mycompany.calc.exceptions.IncorrectSqrtValueExpressionException;
import com.mycompany.calc.exceptions.NoEnoughExpressionException;
import com.mycompany.calc.exceptions.NullDivExpressionException;
import com.mycompany.calc.exceptions.NumericExpressionException;
import com.mycompany.calc.exceptions.ParametricExpressionException;
import com.mycompany.calc.exceptions.StackExpressionException;
import com.mycompany.calc.factory.ExecutionContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import static junit.framework.TestCase.assertEquals;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private ExecutionContext createContext() {
        Stack<Double> stack = new Stack<>();
        Map<String, Double> parameters = new HashMap<>();
        return new ExecutionContext(stack, parameters);
    }


    @Test
    public void testDefinition() throws CalculatorException {
        ExecutionContext context = createContext();
        String[] args = {"a", "5.0"};
        new Calculator(new DefineCommand(context)).executeCommand(args);
        assertEquals(5.0, context.getParameters().get("a"), 0.0);
    }
}
