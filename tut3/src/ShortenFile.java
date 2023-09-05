import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ShortenFile {

    public static void main(String[] args) {
        String inputFilePath = "input.txt";    // Path to the input file
        String outputFilePath = "output.txt";  // Path to the output file
        System.out.println("Current Directory: " + System.getProperty("user.dir"));


        try {
            shortenFile(inputFilePath, outputFilePath);
            System.out.println("File shortened successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void shortenFile(String inputFilePath, String outputFilePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Bỏ cách
                String shortenedLine = line.replaceAll("\\s+", "");
                writer.write(shortenedLine);
                writer.newLine();  // Giữ nguyên dòng
            }
        }
    }


}
