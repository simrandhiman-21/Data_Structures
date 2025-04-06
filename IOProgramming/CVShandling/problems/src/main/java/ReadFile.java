import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
public class ReadFile {
    public static void main(String[] args)throws  Exception {
        String filePath = "C:\\bridgelabz-workspace\\IOProgramming\\CVShandling\\BasicProblems\\students.csv";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
