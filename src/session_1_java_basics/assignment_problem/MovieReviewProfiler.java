package session_1_java_basics.assignment_problem;

import java.util.Scanner;

public class MovieReviewProfiler {

    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        String[] words = review.trim().split("\\s+");
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String w : words) {
            int len = w.length();
            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter movie review (or press enter for demo): ");
        String review = sc.nextLine().trim();

        if (review.isEmpty()) {
            review = "This movie was absolutely fantastic and thrilling";
        }

        classifyWordLengths(review);
        sc.close();
    }
}
