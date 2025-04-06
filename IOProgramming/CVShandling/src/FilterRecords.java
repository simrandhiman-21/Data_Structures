import java.io.BufferedReader;
import java.io.FileReader;

public class FilterRecords {
    public static void main(String[] args) {
        try {
            String path = "C:\\bridgelabz-workspace\\IOProgramming\\CVShandling\\problems\\students.csv";
            BufferedReader br = new BufferedReader(new FileReader(path));
            System.out.println("Students who scored more than 80 marks:");
            String line = br.readLine();
            int count = 0;
            while ((line=br.readLine()) != null) {
                    String[] date=line.split(",");
                    int marks=Integer.parseInt(data[3].trim());
                    if(marks>80) {
                        System.out.println(line);
                        count++;
                    }
            }
            System.out.println("Count is -> "+--count);
            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}