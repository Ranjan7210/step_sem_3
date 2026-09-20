package session_2_strings_and_methods.class_problem;

import java.util.Scanner;

public class PhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append(phone.substring(6));
        sb.insert(6, "-");

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter phone number (or press enter for demo): ");
        String phone = sc.nextLine().trim();

        if (phone.isEmpty()) {
            System.out.println("Input: \"9876543210\" -> " + maskPhoneNumber("9876543210"));
            System.out.println("Input: \"98765\" -> " + maskPhoneNumber("98765"));
        } else {
            System.out.println(maskPhoneNumber(phone));
        }

        sc.close();
    }
}
