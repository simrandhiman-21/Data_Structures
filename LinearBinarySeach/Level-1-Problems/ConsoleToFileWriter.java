import java.io.*;

public class ConsoleToFileWriter {
    public static void writeUserInputToFile(String filePath) {
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter(filePath, true);  // Append mode enabled
             BufferedWriter bw = new BufferedWriter(fw)) {

            System.out.println("Enter text (type 'exit' to stop):");

            String input;
            while (!(input = br.readLine()).equalsIgnoreCase("exit")) {  // Read user input
                bw.write(input);
                bw.newLine();  // Write input to file with a newline
            }

            System.out.println("User input saved to " + filePath);

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "user_input.txt";  // Output file
        writeUserInputToFile(filePath);
    }
}
