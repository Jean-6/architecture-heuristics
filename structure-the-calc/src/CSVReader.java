import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public List<List<Integer>> readCSV(String filePath) throws IOException {
        List<List<Integer>> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            List<Integer> row = new ArrayList<>();
            for (String value : values) {
                row.add(Integer.parseInt(value.trim()));
            }
            data.add(row);
        }
        br.close();
        return data;
    }
}
