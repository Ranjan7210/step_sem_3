package session_2_strings_and_methods.assignment_problem;

import java.util.Scanner;

public class PinValidator {

    public static void checkPinLength(String pin) {
        if (pin != null && pin.length() == 4) {
            System.out.println("PIN length OK.");
        } else {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter PIN (or press enter for demo): ");
        String line = sc.nextLine().trim();

        if (line.isEmpty()) {
            System.out.println("Input: \"482\"");
            checkPinLength("482");
            System.out.println("\nInput: \"4820\"");
            checkPinLength("4820");
        } else {
            checkPinLength(line);
        }

        sc.close();
    }
}
