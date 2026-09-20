package session_2_strings_and_methods.class_problem;

import java.util.Scanner;

public class BankReferenceValidator {

    public static String normalizeReference(String raw) {
        if (raw == null) {
            return null;
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference == null) {
            return "Invalid: reference cannot be null";
        }

        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String bankCode = reference.substring(0, 3);
        String dd = reference.substring(3, 5);
        String mm = reference.substring(5, 7);
        String yy = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ")
          .append(dd).append("/").append(mm).append("/").append(yy)
          .append(" | SEQ: ").append(seq);

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter reference code (or press enter for demo): ");
        String line = sc.nextLine();

        if (line.trim().isEmpty()) {
            String test1 = "  hdf03022600042  ";
            String norm1 = normalizeReference(test1);
            System.out.println("Input: \"" + test1 + "\" -> " + validateAndFormat(norm1));

            String test2 = "12F03022600042";
            String norm2 = normalizeReference(test2);
            System.out.println("Input: \"" + test2 + "\" -> " + validateAndFormat(norm2));
        } else {
            String norm = normalizeReference(line);
            System.out.println(validateAndFormat(norm));
        }

        sc.close();
    }
}
