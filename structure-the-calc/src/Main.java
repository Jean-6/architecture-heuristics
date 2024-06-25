import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //cmd1 : Javac Main.java
        //cmd2: java Main "./data/numbers.csv" "*"

        if (args.length != 2) {
            System.out.println("Usage: calc <file.csv> <operation>");
            return;
        }

        String filePath = args[0];
        String operation = args[1];

        System.out.print("filePath : "+args[0]);
        System.out.print("\noperation : "+args[1]);

        if (!operation.equals("+") && !operation.equals("*")) {
            System.out.println("Invalid operation. Use + or *.");
            return;
        }

        CSVReader csvReader = new CSVReader();
        Calculator calculator = new Calculator();

        try {
            List<List<Integer>> data = csvReader.readCSV(filePath);
            int result = calculator.calculate(data, operation);
            System.out.println("Result: " + result);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

}