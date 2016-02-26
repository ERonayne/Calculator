package calc;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ronaynee on 2/26/2016.
 */
public class Calculator {

    private Stack<String> history;

    public Calculator() {
        history = new Stack<String>();
    }

    public Integer add(List<Integer> integers) {
        Integer result = null;
        if(!integers.isEmpty()) {
            result = integers.get(0);;
            for (int i=1; i<integers.size(); i++) {
                result += integers.get(i);
            }
        }
        return result;
    }

    public Integer subtract(List<Integer> integers) {
        Integer result = null;
        if(!integers.isEmpty()) {
            result = integers.get(0);
            for (int i=1; i<integers.size(); i++) {
                result -= integers.get(i);
            }
        }
        return result;
    }

    public Integer multiply(List<Integer> integers) {
        Integer result = null;
        if(!integers.isEmpty()) {
            result = integers.get(0);;
            for (int i=1; i<integers.size(); i++) {
                result *= integers.get(i);
            }
        }
        return result;
    }

    public Double divide(List<Integer> integers) {
        Double result = null;
        if(!integers.isEmpty()) {
            result = integers.get(0).doubleValue();
            for (int i=1; i<integers.size(); i++) {
                if(integers.get(i) == 0) {
                    result = Double.NaN;
                    break;
                } else {
                    result /= integers.get(i).doubleValue();
                }
            }
        }
        return result;
    }

    public Double root(List<Integer> integers) {
        Double result = null;
        if(integers.size() == 1) {
            result = Math.sqrt(integers.get(0));
        }
        return result;
    }

    public void addHistory(String command, List<Integer> integers, Number result) {
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
            this.history.push(history);
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

    public String printHistory(PrintStream stream) {
        Stack<String> tempHistory = cloneHistory();
        int index = 1;
        String fullHistory = "";
        while(!tempHistory.isEmpty()) {
            fullHistory += index++ + ":  " + tempHistory.pop() + "\n";
        }
        stream.print(fullHistory);
        return fullHistory;
    }

    public Stack<String> getHistory() {
        return this.history;
    }

    public String getHistoryValue(int depth) {
        Stack<String> tempHistory = cloneHistory();
        String retVal = null;
        if (depth <= tempHistory.size()) {
            for (int i = depth; i > 0; i--) {
                if (!tempHistory.isEmpty()) {
                    String[] tokens = tempHistory.pop().split(" ");
                    retVal = tokens[tokens.length - 1];
                }
            }
        }
        return retVal;
    }

    private Stack<String> cloneHistory() {
        return (Stack<String>) this.history.clone();
    }

    public void clearHistory() {
        this.history.clear();
    }

}
