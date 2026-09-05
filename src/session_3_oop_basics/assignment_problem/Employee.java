package session_3_oop_basics.assignment_problem;

import java.util.Scanner;

public class Employee {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter permanent employee details: ");
        String line1 = sc.nextLine();
        String[] parts1;
        if (line1.contains(":")) {
            parts1 = line1.substring(line1.indexOf(":") + 1).split(", ");
        } else {
            parts1 = line1.split(", ");
        }
        String permId = parts1[0].trim();
        String permName = parts1[1].trim();
        double permSalary = Double.parseDouble(parts1[2].trim());
        Employee e1 = new Employee(permId, permName, permSalary);

        System.out.print("Enter intern employee details: ");
        String line2 = sc.nextLine();
        String[] parts2;
        if (line2.contains(":")) {
            parts2 = line2.substring(line2.indexOf(":") + 1).split(", ");
        } else {
            parts2 = line2.split(", ");
        }
        String internId = parts2[0].trim();
        String internName = parts2[1].trim();
        Employee e2 = new Employee(internId, internName);

        e1.printProfile();
        e2.printProfile();
        sc.close();
    }
}
