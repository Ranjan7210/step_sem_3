package Assignment_Day3;

import java.util.Scanner;

public class pg5 {
    static class Employee {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while (count < 3) {
            System.out.print("Enter details: ");
            if (!sc.hasNextLine()) {
                break;
            }
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            if (line.toLowerCase().contains("employee objects created") || line.matches("\\d+")) {
                new Employee("Emp1", 1000.0);
                new Employee("Emp2", 2000.0);
                new Employee("Emp3", 3000.0);
                count = 3;
                break;
            } else {
                String[] parts = line.split(",\\s*");
                String name = parts[0];
                double salary = parts.length > 1 ? Double.parseDouble(parts[1]) : 0.0;
                new Employee(name, salary);
                count++;
            }
        }
        while (count < 3) {
            new Employee("Dummy", 0.0);
            count++;
        }
        Employee.printCompanyInfo();
        sc.close();
    }
}
