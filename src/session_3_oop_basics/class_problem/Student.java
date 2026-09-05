package session_3_oop_basics.class_problem;

import java.util.Scanner;

public class Student {
    String name;
    int attendance;
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName + " Students created: " + studentCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student 1 details (Name, Attendance): ");
        String line1 = sc.nextLine();
        String[] parts1 = line1.split(", ");
        Student s1 = new Student(parts1[0].trim(), Integer.parseInt(parts1[1].trim()));

        System.out.print("Enter Student 2 details (Name, Attendance): ");
        String line2 = sc.nextLine();
        String[] parts2 = line2.split(", ");
        Student s2 = new Student(parts2[0].trim(), Integer.parseInt(parts2[1].trim()));

        Student.printCollegeInfo();

        sc.close();
    }
}
