package Day4;

import java.util.Scanner;

public class LateFee {
    String regNo;
    double totalFee;

    public LateFee(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    public final double calculateLateFee(int daysLate) {
        if (daysLate <= 0) {
            return 0.0;
        }
        return daysLate * (0.01 * totalFee);
    }

    public final void printSummary(int daysLate) {
        if (daysLate <= 0) {
            System.out.println(regNo + " - On time, no late fee");
        } else {
            double lateFee = calculateLateFee(daysLate);
            System.out.println(regNo + " | Total Fee: Rs " + totalFee + " | Late Fee: Rs " + lateFee);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of student fee accounts: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        LateFee[] accounts = new LateFee[n];
        int[] daysLate = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Registration Number for account " + (i + 1) + " (e.g. RA001): ");
            String regNo = sc.nextLine().trim();

            System.out.print("Enter total fee for " + regNo + ": ");
            double totalFee = Double.parseDouble(sc.nextLine().trim());

            System.out.print("Enter days late for " + regNo + ": ");
            daysLate[i] = Integer.parseInt(sc.nextLine().trim());

            accounts[i] = new LateFee(regNo, totalFee);
        }

        System.out.println("\n--- Late Fee Summary ---");
        for (int i = 0; i < n; i++) {
            accounts[i].printSummary(daysLate[i]);
        }

        sc.close();
    }
}
