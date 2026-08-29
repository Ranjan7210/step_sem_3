package Day4;

import java.util.Scanner;

class Employee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class pg5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter object creation command / number of employees: ");
        if (sc.hasNextLine()) {
            String line = sc.nextLine();
            int count = 3;
            try {
                count = Integer.parseInt(line.split(" ")[0].trim());
            } catch (Exception e) {
            }

            for (int i = 0; i < count; i++) {
                if (sc.hasNextLine()) {
                    String empLine = sc.nextLine();
                    String[] parts = empLine.split(", ");
                    if (parts.length >= 2) {
                        new Employee(parts[0].trim(), Double.parseDouble(parts[1].trim()));
                    } else {
                        new Employee("Dummy", 0);
                    }
                } else {
                    new Employee("Dummy", 0);
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                new Employee("Dummy", 0);
            }
        }

        Employee.printCompanyInfo();
        sc.close();
    }
}
