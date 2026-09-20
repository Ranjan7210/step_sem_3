package session_1_java_basics.class_problem;

import java.util.Scanner;

public class FirstNonRepeatingChar {

    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '\0';
    }

    public static void checkAndDisplay(String input) {
        char result = findFirstNonRepeatingChar(input);
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string (or press enter for demo): ");
        String line = sc.nextLine().trim();

        if (line.isEmpty()) {
            System.out.println("Input: \"swiss\"");
            checkAndDisplay("swiss");
            System.out.println("\nInput: \"aabbcc\"");
            checkAndDisplay("aabbcc");
        } else {
            System.out.println("Input: \"" + line + "\"");
            checkAndDisplay(line);
        }

        sc.close();
    }
}
