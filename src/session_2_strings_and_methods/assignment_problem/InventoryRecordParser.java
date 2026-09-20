package session_2_strings_and_methods.assignment_problem;

import java.util.Scanner;

public class InventoryRecordParser {

    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String product = fields[0].trim();
        String sku = fields[1].trim();
        String qty = fields[2].trim();

        System.out.println("Product: " + product + " | SKU: " + sku + " | Qty: " + qty);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter inventory CSV line (or press enter for demo): ");
        String line = sc.nextLine().trim();

        if (line.isEmpty()) {
            parseInventoryRecord("Wireless Mouse,WM-2201,150");
            parseInventoryRecord("Wireless Mouse,150");
        } else {
            parseInventoryRecord(line);
        }

        sc.close();
    }
}
