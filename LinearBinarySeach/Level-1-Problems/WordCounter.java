import java.io.*;

public class WordCounter {
    public static int countWordOccurrences(String filePath, String targetWord) {
        int count = 0;

        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {  // Read each line
                String[] words = line.split("\\s+");  // Split line into words (space-based)
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {  // Case-insensitive match
                        count++;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return count;
    }

    public static void main(String[] args) {
        String filePath = "example.txt";  // Specify your file path
        String targetWord = "Java";  // Word to count
        int occurrences = countWordOccurrences(filePath, targetWord);
        System.out.println("The word '" + targetWord + "' appears " + occurrences + " times in the file.");
    }
}
