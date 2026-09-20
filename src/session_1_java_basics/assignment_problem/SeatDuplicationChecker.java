package session_1_java_basics.assignment_problem;

import java.util.Scanner;

public class SeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No Duplicate Seats Found");
            return;
        }

        boolean[] reported = new boolean[seatNumbers.length];
        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            if (reported[i]) {
                continue;
            }
            boolean isDup = false;
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    isDup = true;
                    reported[j] = true;
                }
            }
            if (isDup) {
                duplicateFound = true;
                System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of seats (or 0 for sample demo): ");
        String line = sc.nextLine().trim();
        int n = 0;
        if (!line.isEmpty()) {
            try {
                n = Integer.parseInt(line);
            } catch (NumberFormatException ignored) {
            }
        }

        if (n <= 0) {
            int[] test1 = {101, 102, 103, 102, 105};
            checkDuplicateSeats(test1);

            int[] test2 = {101, 102, 103, 104, 105};
            checkDuplicateSeats(test2);
        } else {
            int[] seats = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Seat " + (i + 1) + ": ");
                seats[i] = Integer.parseInt(sc.nextLine().trim());
            }
            checkDuplicateSeats(seats);
        }

        sc.close();
    }
}
