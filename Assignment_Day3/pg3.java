package Assignment_Day3;

import java.util.Scanner;

class Employee {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public Employee(String empId, String empName) {
        this(empId, empName, 0.0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }
}

public class pg3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee 1 details: ");
        if (sc.hasNextLine()) {
            String line1 = sc.nextLine();
            Employee emp1 = parseEmployee(line1);
            System.out.print("Enter employee 2 details: ");
            if (sc.hasNextLine()) {
                String line2 = sc.nextLine();
                Employee emp2 = parseEmployee(line2);
                emp1.printProfile();
                emp2.printProfile();
            }
        }
        sc.close();
    }

    private static Employee parseEmployee(String line) {
        String cleanLine = line.replace("Permanent:", "").replace("Intern:", "").trim();
        String[] parts = cleanLine.split(",\\s*");
        if (parts.length == 3) {
            return new Employee(parts[0], parts[1], Double.parseDouble(parts[2]));
        } else {
            return new Employee(parts[0], parts[1]);
        }
    }
}
