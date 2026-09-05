package Day4;

import java.util.Scanner;

class FeeAccount {
    String studentName;

    public FeeAccount(String studentName) {
        this.studentName = studentName;
    }
}

class HostelFeeAccount extends FeeAccount {
    public HostelFeeAccount(String studentName) {
        super(studentName);
    }
}

public class AccountPayment {
    static int hostelCount = 0;
    static int dayScholarCount = 0;

    public static void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            System.out.println("Paid in two installments (hostel account)");
            hostelCount++;
        } else if (account instanceof FeeAccount) {
            System.out.println("Paid in one go (day-scholar account)");
            dayScholarCount++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of accounts: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        FeeAccount[] accounts = new FeeAccount[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter account type for account " + (i + 1) + " (1 for Hostel, 2 for Day-scholar): ");
            int type = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Enter student name: ");
            String name = sc.nextLine().trim();

            if (type == 1) {
                accounts[i] = new HostelFeeAccount(name);
            } else {
                accounts[i] = new FeeAccount(name);
            }
        }

        System.out.print("Enter payment amount for each account: ");
        double amount = Double.parseDouble(sc.nextLine().trim());

        System.out.println("\n--- Processing Batch Payments ---");
        for (int i = 0; i < n; i++) {
            processPayment(accounts[i], amount);
        }

        System.out.println("Hostel accounts processed: " + hostelCount + " | Day-scholar accounts processed: " + dayScholarCount);

        sc.close();
    }
}
