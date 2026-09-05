package Assignment_Day3;

import java.util.Scanner;

public class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double openingSalary) {
        if (openingSalary < 0) {
            System.out.println("Warning: Basic salary cannot be negative. Setting basicSalary to 0.0");
            this.basicSalary = 0.0;
        } else {
            this.basicSalary = openingSalary;
        }
        this.bonus = 0.0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Bonus amount must be positive.");
        } else {
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Error: Tax percentage must be between 0 and 100.");
        } else {
            this.basicSalary = this.basicSalary - (this.basicSalary * (percent / 100.0));
            System.out.println("Tax deducted: " + (int) percent + "%");
        }
    }

    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter basic salary: ");
        String line1 = sc.nextLine();
        double basicSalary;
        if (line1.contains("=")) {
            basicSalary = Double.parseDouble(line1.split("=")[1].trim());
        } else {
            basicSalary = Double.parseDouble(line1.trim());
        }

        PayrollAccount account = new PayrollAccount(basicSalary);

        System.out.print("Enter bonus: ");
        String line2 = sc.nextLine();
        double bonus;
        if (line2.contains("(") && line2.contains(")")) {
            bonus = Double.parseDouble(line2.substring(line2.indexOf("(") + 1, line2.indexOf(")")).trim());
        } else {
            bonus = Double.parseDouble(line2.trim());
        }
        account.creditBonus(bonus);

        System.out.print("Enter tax: ");
        String line3 = sc.nextLine();
        double tax;
        if (line3.contains("(") && line3.contains(")")) {
            tax = Double.parseDouble(line3.substring(line3.indexOf("(") + 1, line3.indexOf(")")).trim());
        } else {
            tax = Double.parseDouble(line3.trim());
        }
        account.deductTax(tax);

        System.out.println("Net salary: Rs " + account.getNetSalary());
        sc.close();
    }
}
