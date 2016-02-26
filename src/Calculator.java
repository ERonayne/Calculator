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

    public Stack<String> getHistory() {
        return this.history;
    }

}
