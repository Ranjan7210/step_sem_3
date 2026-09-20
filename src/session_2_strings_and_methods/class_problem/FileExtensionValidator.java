package session_2_strings_and_methods.class_problem;

import java.util.Scanner;

public class FileExtensionValidator {

    public static String validateFileExtension(String filename) {
        if (filename == null) {
            return "Rejected — invalid file type";
        }

        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(lastDotIndex + 1);
        if (extension.equalsIgnoreCase("pdf") || extension.equalsIgnoreCase("docx") || extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter filename (or press enter for demo): ");
        String filename = sc.nextLine().trim();

        if (filename.isEmpty()) {
            System.out.println("Input: \"Assignment1.PDF\" -> " + validateFileExtension("Assignment1.PDF"));
            System.out.println("Input: \"notes.txt\" -> " + validateFileExtension("notes.txt"));
        } else {
            System.out.println(validateFileExtension(filename));
        }

        sc.close();
    }
}
