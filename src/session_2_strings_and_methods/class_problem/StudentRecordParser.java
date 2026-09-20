package session_2_strings_and_methods.class_problem;

import java.util.Scanner;

public class StudentRecordParser {

    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNo = fields[1].trim();
        String dept = fields[2].trim();

        System.out.println("Name: " + name + " | Roll No: " + rollNo + " | Dept: " + dept);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter CSV record (or press enter for demo): ");
        String line = sc.nextLine().trim();

        if (line.isEmpty()) {
            parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
            parseStudentRecord("Ananya Verma,CSE");
        } else {
            parseStudentRecord(line);
        }

        sc.close();
    }
}
