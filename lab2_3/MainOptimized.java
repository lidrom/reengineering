import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MainOptimized {

    public static void main(String[] args) throws IOException {

        LocalDateTime start = LocalDateTime.now();

        Pattern pattern = Pattern.compile("[^A-Za-z ]");

        Map<String, Long> freqMap = new HashMap<>();

        // Use BufferedReader to process the file line by line
        try (BufferedReader br = Files.newBufferedReader(Paths.get("../lab2/harry.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Clean and process each line
                line = pattern.matcher(line).replaceAll(" ").toLowerCase(Locale.ROOT);
                String[] words = line.split("\\s+");

                // Populate the frequency map
                for (String word : words) {
                    if (!word.isEmpty()) {
                        freqMap.put(word, freqMap.getOrDefault(word, 0L) + 1);
                    }
                }
            }
        }

        List<Map.Entry<String, Long>> topWords = freqMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .limit(30)
                .collect(Collectors.toList());

        topWords.forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

        System.out.println("------");
        System.out.println("Execution time: " + ChronoUnit.MILLIS.between(start, LocalDateTime.now()) + " ms");
    }
}
