package Day4;

import java.util.Scanner;

public class SrmStudent {
    static String collegeName;
    static String academicYear;

    String name;

    static {
        collegeName = "SRM University";
        academicYear = "2026-2027";
        System.out.println("College info loaded");
    }

    public SrmStudent(String name) {
        this.name = name;
        System.out.println("Student record created: " + this.name);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        SrmStudent[] students = new SrmStudent[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name " + (i + 1) + ": ");
            String name = sc.nextLine().trim();
            students[i] = new SrmStudent(name);
        }

        sc.close();
    }
}
