package Assignment_Day3;

import java.util.Scanner;

class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Basic salary cannot be negative. Starting at 0.");
            this.basicSalary = 0.0;
        } else {
            this.basicSalary = basicSalary;
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
            this.basicSalary -= (this.basicSalary * percent / 100.0);
            if (percent == (int) percent) {
                System.out.println("Tax deducted: " + (int) percent + "%");
            } else {
                System.out.println("Tax deducted: " + percent + "%");
            }
        }
    }

    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }
}

public class pg2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter basic salary: ");
        if (sc.hasNextLine()) {
            String line1 = sc.nextLine();
            double basicSalary = parseValue(line1);
            PayrollAccount account = new PayrollAccount(basicSalary);

            System.out.print("Enter bonus: ");
            if (sc.hasNextLine()) {
                String line2 = sc.nextLine();
                double bonusAmount = parseValue(line2);
                account.creditBonus(bonusAmount);
            }

            System.out.print("Enter tax percentage: ");
            if (sc.hasNextLine()) {
                String line3 = sc.nextLine();
                double taxPercent = parseValue(line3);
                account.deductTax(taxPercent);
            }

            System.out.println("Net salary: Rs " + account.getNetSalary());
        }
        sc.close();
    }

    private static double parseValue(String line) {
        if (line.contains("=")) {
            return Double.parseDouble(line.split("=")[1].trim());
        } else if (line.contains("(") && line.contains(")")) {
            return Double.parseDouble(line.substring(line.indexOf('(') + 1, line.indexOf(')')).trim());
        } else {
            return Double.parseDouble(line.trim());
        }
    }
}
