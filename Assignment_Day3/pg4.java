package Assignment_Day3;

import java.util.Scanner;

class HallTicket {
    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class pg4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter details: ");
        if (sc.hasNextLine()) {
            String line1 = sc.nextLine();
            String[] p1 = parseNameAndSeat(line1);
            String studentName1 = p1[0];
            int seatNumber1 = Integer.parseInt(p1[1]);
            int newSeatNumber = -1;
            String studentName2 = "";
            int seatNumber2 = -1;

            if (line1.contains("new HallTicket")) {
                System.out.print("Enter copy assignment: ");
                if (sc.hasNextLine()) {
                    sc.nextLine();
                }
                System.out.print("Enter seat modification: ");
                if (sc.hasNextLine()) {
                    String line3 = sc.nextLine();
                    newSeatNumber = parseSeat(line3);
                }
                System.out.print("Enter separate ticket: ");
                if (sc.hasNextLine()) {
                    String line4 = sc.nextLine();
                    String[] p2 = parseNameAndSeat(line4);
                    studentName2 = p2[0];
                    seatNumber2 = Integer.parseInt(p2[1]);
                }
            } else {
                System.out.print("Enter new seat number: ");
                if (sc.hasNextLine()) {
                    String line2 = sc.nextLine();
                    newSeatNumber = parseSeat(line2);
                }
                System.out.print("Enter separate ticket: ");
                if (sc.hasNextLine()) {
                    String line3 = sc.nextLine();
                    String[] p2 = parseNameAndSeat(line3);
                    studentName2 = p2[0];
                    seatNumber2 = Integer.parseInt(p2[1]);
                }
            }

            HallTicket priya = new HallTicket(studentName1, seatNumber1);
            HallTicket copy = priya;
            if (newSeatNumber != -1) {
                copy.seatNumber = newSeatNumber;
            }

            System.out.println(priya.studentName + "'s seatNumber (via first variable): " + priya.seatNumber);
            System.out.println("copy == priya: " + (copy == priya));

            if (!studentName2.isEmpty()) {
                HallTicket separate = new HallTicket(studentName2, seatNumber2);
                System.out.println("separate == priya: " + (separate == priya));
            } else {
                HallTicket separate = new HallTicket(studentName1, priya.seatNumber);
                System.out.println("separate == priya: " + (separate == priya));
            }
        }
        sc.close();
    }

    private static String[] parseNameAndSeat(String line) {
        if (line.contains("new HallTicket(")) {
            int start = line.indexOf("new HallTicket(") + 15;
            int end = line.lastIndexOf(")");
            String content = line.substring(start, end);
            String[] parts = content.split(",\\s*");
            String name = parts[0].replace("\"", "").trim();
            String seat = parts[1].replace(";", "").trim();
            return new String[] { name, seat };
        } else {
            String[] parts = line.split(",\\s*");
            return new String[] { parts[0].trim(), parts[1].trim() };
        }
    }

    private static int parseSeat(String line) {
        if (line.contains("=")) {
            String right = line.split("=")[1].trim().replace(";", "");
            return Integer.parseInt(right);
        } else {
            return Integer.parseInt(line.trim());
        }
    }
}
