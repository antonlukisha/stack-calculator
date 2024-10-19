package com.mycompany.stackcalculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import com.mycompany.calc.Commands.Command;
import com.mycompany.calc.factory.CommandFactory;
import com.mycompany.calc.factory.ExecutionContext;

public class Main {

    public static void main(String[] args) {
        try {
            Stack<Double> stack = new Stack();
            Map<String, Double> parameters = new HashMap();
            ExecutionContext context = new ExecutionContext(stack, parameters);
            CommandFactory commandFactory = new CommandFactory(context);
            if (args.length > 0) {
                processCommandsFromFile(args[0], commandFactory);
            } else {
                processCommandsFromConsole(commandFactory);
            }
        } catch (IOException exception) {
            System.out.println("Error of setting: " + exception.getMessage());
        }
    }

    private static void processCommandsFromFile(String filename, CommandFactory commandFactory) {
        try (BufferedReader reader = new BufferedReader(new FileReader("/com/mycompany/stackcalculator/" + filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length > 0) {
                    String commandName = parts[0];
                    Command command = commandFactory.getCommand(commandName);
                    if (command != null) {
                        command.execute(parts);
                    } else {
                        System.out.println("Unknown command: " + commandName);
                    }
                }
            }
        } catch (IOException exception) {
            System.out.println("Error reading file: " + exception.getMessage());
        }
    }

    private static void processCommandsFromConsole(CommandFactory commandFactory) {
        Scanner scanner = new Scanner(System.in);
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            String[] parts = line.split(" ");
            if (parts.length > 0) {
                String commandName = parts[0];
                Command command = commandFactory.getCommand(commandName);
                if (command != null) {
                    command.execute(parts);
                } else {
                    System.out.println("Unknown command: " + commandName);
                }
            }
        }
    }
}

