package com.mycompany.calc.сalculator;

import com.mycompany.calc.сommands.Command;
import com.mycompany.calc.exceptions.*;
import java.util.logging.*;

public class Calculator {
    private final Logger logger;
    private final Command command;

    public Calculator(Command command) {
        this.command = command;
        logger = Logger.getLogger(Calculator.class.getName());
    }
    
    public void executeCommand(String[] args){
        try {
            String log = command.execute(args);
            logger.log(Level.INFO, log);
        } catch (CalculatorException | AriphmeticException exception) {
            logger.log(Level.WARNING, exception.getMessage());
            System.err.println(exception.getMessage());
        }
    }
}
