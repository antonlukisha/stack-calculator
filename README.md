# Stack Calculator


[About](#dart-about) | [Description](#pencil2-description) | [Algorithm](#triangular_ruler-algorithm) | [Bash Example](#paperclip-bash-example) | [License](#page_with_curl-license)


## :dart: About

This project implements a stack calculator in Java. 
## :pencil2: Description

This program gets filename as argument, which has commands of calculator. In case with no argument, to use standart input thread for command reading. Need to use real numbers. To realise next set of commands: 
- POP, PUSH — pop/push number from/to stack.
- + , - , * , /, SQRT – ariphmetic operations. It uses one or two elements of stack, pops from stack and pop result to back.
- PRINT — print top element of stack (without delete).
- DEFINE — define parameter value. After to use everywhere this value as parameter.
To realise set of module tests cover all programm functional.
To realise programm logging.

## :paperclip: Bash Example

To compile, run and work the programm using the command line:

```bash
# Compile the Java file
javac Main.java

# Run the server (example with argument ana without)
java Main file.txt
java Main

# Input the commands and their parameters (example for run with argument)
DEFINE a 4
PUSH a
SQRT
PRINT
```

## :page_with_curl: License

   - Badges: Links have been updated to point to the GitHub repository for the Java project.
   - Bash Example: Provides command examples for compiling and running the program in Java.
   - Code: Example of Java code implementing basic functional of stack calculator.
To configure the badges, replace your-username/stack-calculator-java with the actual parameters of your repository.
