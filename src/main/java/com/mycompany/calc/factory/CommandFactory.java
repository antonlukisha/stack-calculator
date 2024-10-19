package com.mycompany.calc.factory;

import com.mycompany.calc.сommands.Command;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommandFactory {
    private final Map<String, Command> commandMap = new HashMap<>();

    public CommandFactory(ExecutionContext context) throws IOException {
        loadCommands(context);
    }

    private void loadCommands(ExecutionContext context) throws IOException {
        try (InputStream inputStream = getClass().getResourceAsStream("commands_config.properties")) {
            if (inputStream != null) {
                Properties properties = new Properties();
                properties.load(inputStream);
                
                for (String commandName : properties.stringPropertyNames()) {
                    String className = properties.getProperty(commandName);
                    try {
                        Class<?> commandClass = Class.forName(className);
                        if (Command.class.isAssignableFrom(commandClass)) {
                            Command command = (Command) commandClass.getDeclaredConstructor(ExecutionContext.class).newInstance(context);
                            commandMap.put(commandName, command);
                        } else {
                            System.err.println("Class " + className + " does not implement Command interface");
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException exception) {
                        System.err.println("Error loading command class for " + commandName + ": " + exception.getMessage());
                    }
                }
            } else {
                System.err.println("Unable to load commands config file: inputStream is null");
            }
        } catch (IOException exception) {
            System.err.println("Error reading commands config file: " + exception.getMessage());
        }
    }

    public Command getCommand(String commandName) {
        return commandMap.get(commandName);
    }
}
