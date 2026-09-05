package Day4;

import java.util.Scanner;

public class Employee {
    String id;
    double salary;

    public Employee(String id, double salary) {
        this.id = id;
        this.salary = salary;
    }

    public void raiseSalary(double salary) {
        this.salary = this.salary + salary;
    }

    public void display() {
        System.out.println(this.id + " | Final Salary: Rs " + this.salary);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Employee ID for employee " + (i + 1) + " (e.g. E-101): ");
            String id = sc.nextLine().trim();

            System.out.print("Enter starting salary for " + id + ": ");
            double salary = Double.parseDouble(sc.nextLine().trim());

            employees[i] = new Employee(id, salary);
        }

        System.out.print("Enter festival bonus amount to raise for each employee: ");
        double bonus = Double.parseDouble(sc.nextLine().trim());

        System.out.println("\n--- Payroll Details ---");
        for (int i = 0; i < n; i++) {
            employees[i].raiseSalary(bonus);
            employees[i].display();
        }

        sc.close();
    }
}
