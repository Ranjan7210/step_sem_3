package session_2_strings_and_methods.assignment_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WordFrequencyReport {

    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }

        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));

        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleaned.trim().split("\\s+");

        Map<String, Integer> freqMap = new HashMap<>();

        for (String w : words) {
            if (w.isEmpty() || stopWords.contains(w)) {
                continue;
            }
            freqMap.put(w, freqMap.getOrDefault(w, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freqMap.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter feedback (or press enter for demo): ");
        String line = sc.nextLine().trim();

        if (line.isEmpty()) {
            printFilteredWordFrequency("The mentor was great, the session was great and clear.");
        } else {
            printFilteredWordFrequency(line);
        }

        sc.close();
    }
}
