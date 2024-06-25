import java.util.List;

public class Calculator {

    public int calculate(List<List<Integer>> data, String operation) {
        int result = operation.equals("+") ? 0 : 1;

        for (List<Integer> row : data) {
            for (Integer value : row) {
                if (operation.equals("+")) {
                    result += value;
                } else if (operation.equals("*")) {
                    result *= value;
                }
            }
        }
        return result;
    }
}
