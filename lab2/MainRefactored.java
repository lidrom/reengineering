import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class MainRefactored {

    public static void main(String[] args) throws IOException {

        LocalDateTime start = LocalDateTime.now();

        // Read and clean the text file
        String content = new String(Files.readAllBytes(Paths.get("harry.txt")));
        content = content.replaceAll("[^A-Za-z ]", " ").toLowerCase(Locale.ROOT);
        String[] words = content.split("\\s+");

        // Count the frequency of each word using a HashMap
        Map<String, Long> freqMap = Arrays.stream(words)
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        // Sort the entries by frequency in descending order and get the top 30
        List<Map.Entry<String, Long>> topWords = freqMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .limit(30)
                .collect(Collectors.toList());

        // Print the top 30 words with their frequencies
        topWords.forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

        System.out.println("------");
        System.out.println("Execution time: " + ChronoUnit.MILLIS.between(start, LocalDateTime.now()) + " ms");
    }
}