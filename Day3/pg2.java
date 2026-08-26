package Day3;

import java.util.Scanner;

class MessWallet {
    private double balance;

    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Opening balance cannot be negative. Setting balance to 0.0");
            this.balance = 0.0;
        } else {
            this.balance = openingBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Top-up amount must be positive.");
        } else {
            this.balance = this.balance + amount;
        }
    }

    public void deduct(double amount) {
        if (amount > this.balance) {
            System.out.println("Error: Insufficient balance. Cannot deduct.");
        } else {
            this.balance = this.balance - amount;
        }
    }

    public double getBalance() {
        return this.balance;
    }
}

public class pg2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter opening balance: ");
        double openingBalance = sc.nextDouble();
        MessWallet wallet = new MessWallet(openingBalance);
        System.out.println("Balance: " + wallet.getBalance());

        System.out.print("Enter top-up amount: ");
        double topUpAmount = sc.nextDouble();
        wallet.topUp(topUpAmount);
        System.out.println("Balance: " + wallet.getBalance());

        System.out.print("Enter deduction amount: ");
        double deductAmount = sc.nextDouble();
        wallet.deduct(deductAmount);
        System.out.println("Balance: " + wallet.getBalance());

        sc.close();
    }
}
