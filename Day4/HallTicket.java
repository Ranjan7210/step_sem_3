package Day4;

import java.util.Scanner;

public class HallTicket {
    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String studentName = "";
        int initialSeat = 0;
        int newSeat = 0;
        String separateName = "";
        int separateSeat = 0;

        System.out.print("Enter Hall Ticket creation statement / name and seat: ");
        if (sc.hasNextLine()) {
            String line1 = sc.nextLine();
            if (line1.startsWith("HallTicket")) {
                studentName = line1.substring(line1.indexOf("\"") + 1, line1.lastIndexOf("\""));
                initialSeat = Integer
                        .parseInt(line1.substring(line1.lastIndexOf(",") + 1, line1.lastIndexOf(")")).trim());

                System.out.print("Enter copy assignment: ");
                sc.nextLine();

                System.out.print("Enter seat modification statement: ");
                String line3 = sc.nextLine();
                newSeat = Integer.parseInt(line3.split("=")[1].replace(";", "").trim());

                System.out.print("Enter separate ticket creation statement: ");
                String line4 = sc.nextLine();
                separateName = line4.substring(line4.indexOf("\"") + 1, line4.lastIndexOf("\""));
                separateSeat = Integer
                        .parseInt(line4.substring(line4.lastIndexOf(",") + 1, line4.lastIndexOf(")")).trim());
            } else {
                String[] parts1 = line1.split(", ");
                studentName = parts1[0].trim();
                initialSeat = Integer.parseInt(parts1[1].trim());

                System.out.print("Enter new seat number via copy: ");
                newSeat = Integer.parseInt(sc.nextLine().trim());

                System.out.print("Enter separate student name and seat: ");
                String line3 = sc.nextLine();
                String[] parts3 = line3.split(", ");
                separateName = parts3[0].trim();
                separateSeat = Integer.parseInt(parts3[1].trim());
            }
        }

        HallTicket priya = new HallTicket(studentName, initialSeat);
        HallTicket copy = priya;
        copy.seatNumber = newSeat;

        System.out.println(priya.studentName + "'s seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));

        HallTicket separate = new HallTicket(separateName, separateSeat);
        System.out.println("separate == priya: " + (separate == priya));

        sc.close();
    }
}
