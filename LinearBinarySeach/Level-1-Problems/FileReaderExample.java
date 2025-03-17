import java.io.*;

public class FileReaderExample {
    public static void readFile(String filePath) {
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {  // Read each line until EOF
                System.out.println(line);
            }
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "example.txt";  // Specify your file path
        readFile(filePath);
    }
}
