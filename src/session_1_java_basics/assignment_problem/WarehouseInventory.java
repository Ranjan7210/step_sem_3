package session_1_java_basics.assignment_problem;

import java.util.Scanner;

public class WarehouseInventory {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null) {
            return;
        }

        int totalA = 0;
        int totalB = 0;

        int highestQty = Integer.MIN_VALUE;
        String highestSection = "Section A";
        int highestItemNumber = 1;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > highestQty) {
                highestQty = sectionA[i];
                highestSection = "Section A";
                highestItemNumber = i + 1;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highestQty) {
                highestQty = sectionB[i];
                highestSection = "Section B";
                highestItemNumber = i + 1;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB + " | Status: " + status +
                " | Highest Quantity: " + highestQty + " (" + highestSection + ", Item " + highestItemNumber + ")");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of categories per section (or 0 for sample demo): ");
        String line = sc.nextLine().trim();
        int n = 0;
        if (!line.isEmpty()) {
            try {
                n = Integer.parseInt(line);
            } catch (NumberFormatException ignored) {
            }
        }

        if (n <= 0) {
            int[] secA = {20, 15, 30};
            int[] secB = {25, 10, 30};
            analyzeInventory(secA, secB);
        } else {
            int[] secA = new int[n];
            int[] secB = new int[n];
            System.out.println("Enter items for Section A:");
            for (int i = 0; i < n; i++) {
                System.out.print("Section A Item " + (i + 1) + ": ");
                secA[i] = Integer.parseInt(sc.nextLine().trim());
            }
            System.out.println("Enter items for Section B:");
            for (int i = 0; i < n; i++) {
                System.out.print("Section B Item " + (i + 1) + ": ");
                secB[i] = Integer.parseInt(sc.nextLine().trim());
            }
            analyzeInventory(secA, secB);
        }

        sc.close();
    }
}
