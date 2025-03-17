import java.io.*;

public class InputStreamReaderExample {
    public static void readFile(String filePath, String charset) {
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, charset);
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {  // Read file line by line
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "example.txt";  // Specify the file path
        String charset = "UTF-8";  // Specify the character encoding
        readFile(filePath, charset);
    }
}
