package session_2_strings_and_methods.assignment_problem;

import java.util.Scanner;

public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {
        if (sentence == null) {
            return null;
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder();
            for (int j = words[i].length() - 1; j >= 0; j--) {
                reversedWord.append(words[i].charAt(j));
            }

            result.append(reversedWord);
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence (or press enter for demo): ");
        String line = sc.nextLine();

        if (line.isEmpty()) {
            System.out.println(reverseEachWord("hello club"));
        } else {
            System.out.println(reverseEachWord(line));
        }

        sc.close();
    }
}
