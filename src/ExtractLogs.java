import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ExtractLogs {
    
    public static void extractLogs(String inputFile, String targetDate) {
       
        String outputFilePath = "output/output_" + targetDate + ".txt";
        
        File outputDir = new File("output");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
        
                String logDate = line.substring(0, 10);
                
                
                if (logDate.equals(targetDate)) {
                    writer.write(line);
                    writer.newLine();
                }
            }

            System.out.println("Logs for " + targetDate + " have been saved to " + outputFilePath);

        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ExtractLogs <YYYY-MM-DD>");
            System.exit(1);
        }

       
        String targetDate = args[0];

        
        String inputFile = "test_logs.log";

        
        extractLogs(inputFile, targetDate);
    }
}
