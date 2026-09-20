package session_1_java_basics.assignment_problem;

import java.util.Locale;
import java.util.Scanner;

public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            return;
        }

        int totalChars = original.length();
        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = ' ';
        char typedChar = ' ';

        for (int i = 0; i < totalChars; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1;
                origChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        double accuracy = totalChars == 0 ? 100.0 : ((double) matched / totalChars) * 100.0;

        if (firstMismatchPos == -1) {
            System.out.printf(Locale.US, "Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n", matched, totalChars, accuracy);
        } else {
            System.out.printf(Locale.US, "Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matched, totalChars, accuracy, firstMismatchPos, origChar, typedChar);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter original string (or press enter for demo): ");
        String original = sc.nextLine();

        if (original.isEmpty()) {
            checkTypingAccuracy("hello world", "hello worlt");
            checkTypingAccuracy("coding", "coding");
        } else {
            System.out.print("Enter typed string: ");
            String typed = sc.nextLine();
            checkTypingAccuracy(original, typed);
        }

        sc.close();
    }
}
