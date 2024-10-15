import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Stream;

public class MainOptimizedMemory {

    public static void main(String[] args) throws IOException {

        LocalDateTime start = LocalDateTime.now();

        // Initialize a HashMap to store the word frequencies
        Map<String, Long> freqMap = new HashMap<>();

        // Read and process the file line by line, reducing memory footprint
        try (Stream<String> lines = Files.lines(Paths.get("../lab2/harry.txt"))) {
            lines.flatMap(line -> Arrays.stream(line.replaceAll("[^A-Za-z ]", " ")
                                        .toLowerCase(Locale.ROOT).split("\\s+")))
                 .filter(word -> !word.isEmpty()) // Avoid empty words
                 .forEach(word -> freqMap.put(word, freqMap.getOrDefault(word, 0L) + 1));
        }

        // Use a priority queue to keep track of the top 30 words
        PriorityQueue<Map.Entry<String, Long>> topWords = new PriorityQueue<>(
                Comparator.comparingLong(Map.Entry::getValue));

        for (Map.Entry<String, Long> entry : freqMap.entrySet()) {
            topWords.offer(entry);
            if (topWords.size() > 30) {
                topWords.poll(); // Remove the word with the lowest frequency
            }
        }

        // Convert the priority queue to a list and reverse for descending order
        List<Map.Entry<String, Long>> result = new ArrayList<>(topWords);
        result.sort((a, b) -> Long.compare(b.getValue(), a.getValue()));

        // Print the top 30 words with their frequencies
        result.forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

        System.out.println("------");
        System.out.println("Execution time: " + ChronoUnit.MILLIS.between(start, LocalDateTime.now()) + " ms");
    }
}
