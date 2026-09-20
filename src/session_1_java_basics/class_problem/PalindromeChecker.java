package session_1_java_basics.class_problem;

import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        char[] chars = text.toCharArray();
        char[] reversed = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static void checkAndPrint(String text) {
        boolean iter = isPalindromeIterative(text);
        boolean rec = isPalindromeRecursive(text);
        boolean arr = isPalindromeArrayReversal(text);

        String sIter = iter ? "Palindrome" : "Not Palindrome";
        String sRec = rec ? "Palindrome" : "Not Palindrome";
        String sArr = arr ? "Palindrome" : "Not Palindrome";

        System.out.println("Iterative: " + sIter + " | Recursive: " + sRec + " | Array Reversal: " + sArr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to check palindrome (or press enter for demo): ");
        String line = sc.nextLine().trim();

        if (line.isEmpty()) {
            System.out.println("Input: \"madam\"");
            checkAndPrint("madam");
            System.out.println("\nInput: \"hello\"");
            checkAndPrint("hello");
        } else {
            System.out.println("Input: \"" + line + "\"");
            checkAndPrint(line);
        }

        sc.close();
    }
}
