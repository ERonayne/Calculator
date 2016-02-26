import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
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
                continue;
            }

            Calculator calc = new Calculator();
            String result = "";
            switch (command) {
                case "add":
                    result = "" + calc.add(integers);
                    System.out.println(result);
                    break;
                case "sub":
                    result = "" + calc.subtract(integers);
                    System.out.println(result);
                    break;
                case "mul":
                    result = "" + calc.multiply(integers);
                    System.out.println(result);
                    break;
                case "div":
                    result = "" + calc.divide(integers);
                    System.out.println(result);
                    break;
                case "his":
                    Stack<String> hist = calc.getHistory();
                    System.out.println(result);
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.err.println("unknown format!");
            }
        }
    }

    private static boolean convertStringsToInt(String[] tokens, List<Integer> integers) {
        for (int i = 1; i < tokens.length; i++) {
            try {
                int integer = Integer.parseInt(tokens[i]);
                integers.add(integer);
            } catch (NumberFormatException e) {
                System.err.println("Invalid format!");
                return false;
            }
        }
        return true;
    }
}
