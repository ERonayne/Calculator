import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Boolean exit = false;
        while(!exit) {
            System.out.println("Enter a command: ");
            // try {
            String input = scan.nextLine();
            String[] tokens = input.split(" ");
            String command = tokens[0];
            List<Integer> integers = new ArrayList<Integer>();
            for (int i = 1; i < tokens.length; i++) {
                try {
                    int integer = Integer.parseInt(tokens[1]);
                    integers.add(integer);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid format!");
                    continue;
                }
            }
            Calculator calc = new Calculator();
            String result = "";
            switch (command) {
                case "add":
                    result = "" + calc.add(integers);
                    break;
                case "sub":
                    result = "" + calc.subtract(integers);
                    break;
                case "mul":
                    result = "" + calc.multiply(integers);
                    break;
                case "div":
                    result = "" + calc.divide(integers);
                    break;
                case "his":
                    Stack<String> hist = calc.getHistory();
                    break;
                default:
                    System.out.println(command);
                    break;
            }
            System.out.println(result);
        }
    }
}
