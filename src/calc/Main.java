package calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Calculator calc = new Calculator();
        Boolean exit = false;
        while(!exit) {
            System.out.println("Enter a command, \"exit\" to quit: ");
            String input = scan.nextLine();
            String[] tokens = input.split(" ");

            //add, mul, his, div, etc
            String command = tokens[0];

            //convert input into integers
            List<Integer> integers = new ArrayList<Integer>();
            if(!convertStringsToInt(calc, tokens, integers)) {
                System.out.println("Values must be integers!");
                continue;
            }

            Number value;
            switch (command) {
                case "add":
                    value = calc.add(integers);
                    addHistory(command, integers, calc, value);
                    printResult(value);
                    break;
                case "sub":
                    value = calc.subtract(integers);
                    addHistory(command, integers, calc, value);
                    printResult(value);
                    break;
                case "mul":
                    value = calc.multiply(integers);
                    addHistory(command, integers, calc, value);
                    printResult(value);
                    break;
                case "div":
                    value = calc.divide(integers);
                    addHistory(command, integers, calc, value);
                    printResult(value);
                    break;
                case "root":
                    if (!integers.isEmpty() && integers.size() != 1) {
                        System.out.println("Square root can only be used on 1 integer!");
                    } else {
                        value = calc.root(integers);
                        addHistory(command, integers, calc, value);
                        printResult(value);
                    }
                    break;
                case "his":
                    calc.printHistory(System.out);
                    break;
                case "clear":
                    calc.clearHistory();
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Command! Valid commands are \"add\", " +
                            "\"sub\", \"mul\", \"div\", \"his\", \"clear\", and \"root\".\n");
            }
        }
    }

    private static void printResult(Number value) {
        if (value != null) {
            String response = value.toString();
            if (Double.isNaN(value.doubleValue())) {
                response = "Divide by 0 error.";
            }
            System.out.println(response);
        }
    }

    private static void addHistory(String command, List<Integer> integers, Calculator calc, Number result) {
        if (result != null) {
            command = convertCommandToOperator(command);
            String history = "";
            String rootUnicode = "\u221A";
            if (command.equals(rootUnicode)) {
                history = command + integers.get(0) + " ";
            } else {
                for (int i = 0; i < integers.size(); i++) {
                    history += integers.get(i) + " ";
                    if (i != integers.size() - 1) {
                        history += command + " ";
                    }
                }
            }
            history += "= " + result;
            calc.addHistory(history);
        }
    }

    private static String convertCommandToOperator(String command) {
        String retVal = command;
        switch (command) {
            case "add":
                retVal = "+";
                break;
            case "sub":
                retVal = "-";
                break;
            case "mul":
                retVal = "*";
                break;
            case "div":
                retVal = "/";
                break;
            case "root":
                retVal = "\u221A";
                break;
        }
        return retVal;
    }

    private static boolean convertStringsToInt(Calculator calc, String[] tokens, List<Integer> integers) {
        boolean retVal = true;
        for (int i = 1; i < tokens.length; i++) {
            String token = tokens[i];
            try {
                if(token.startsWith("!")) {
                    int depth = Integer.parseInt(token.substring(1));
                    if (depth > 0) {
                        token = calc.getHistoryValue(depth);
                    }
                }
                int integer = Integer.parseInt(token);
                integers.add(integer);
            } catch (NumberFormatException e) {
                retVal = false;
                break;
            }
        }
        return retVal;
    }
}
