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
            if(!convertStringsToInt(tokens, integers)) {
                System.out.println("Values must be integers!");
                continue;
            }

            String result = "";
            switch (command) {
                case "add":
                    result = "" + calc.add(integers);
                    addHistory(command, integers, calc, result);
                    System.out.println(result);
                    break;
                case "sub":
                    result = "" + calc.subtract(integers);
                    addHistory(command, integers, calc, result);
                    System.out.println(result);
                    break;
                case "mul":
                    result = "" + calc.multiply(integers);
                    addHistory(command, integers, calc, result);
                    System.out.println(result);
                    break;
                case "div":
                    result = "" + calc.divide(integers);
                    addHistory(command, integers, calc, result);
                    System.out.println(result);
                    break;
                case "his":
                    calc.printHistory(System.out);
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

    private static void addHistory(String command, List<Integer> integers, Calculator calc, String result) {
        command = convertCommandToOperator(command);
        String history = "";
        for(int i=0; i<integers.size(); i++) {
            history += integers.get(i) + " ";
            if(i != integers.size()-1) {
                history += command + " ";
            }
        }
        history += "= " + result;
        calc.addHistory(history);
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
        }
        return retVal;
    }

    private static boolean convertStringsToInt(String[] tokens, List<Integer> integers) {
        boolean retVal = true;
        for (int i = 1; i < tokens.length; i++) {
            try {
                int integer = Integer.parseInt(tokens[i]);
                integers.add(integer);
            } catch (NumberFormatException e) {
                retVal = false;
                break;
            }
        }
        return retVal;
    }
}
