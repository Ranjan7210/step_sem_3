package session_1_java_basics.class_problem;

import java.util.Locale;
import java.util.Scanner;

public class BmiCalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-10s | %-12s | %-12s | %-10s | %-12s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double h = heights[i];
            double w = weights[i];
            double bmi = w / (h * h);
            String status = getBmiStatus(bmi);
            System.out.printf(Locale.US, "Person %-3d | %-12.2f | %-12.2f | %-10.2f | %-12s%n", (i + 1), h, w, bmi, status);
        }
        System.out.println("---------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons (or 0 for sample demo): ");
        String line = sc.nextLine().trim();
        int n = 0;
        if (!line.isEmpty()) {
            try {
                n = Integer.parseInt(line);
            } catch (NumberFormatException ignored) {
            }
        }

        if (n <= 0) {
            double[] sampleHeights = {1.75, 1.60, 1.80, 1.65, 1.70, 1.55, 1.85, 1.68, 1.72, 1.62};
            double[] sampleWeights = {70.0, 90.0, 68.0, 50.0, 80.0, 42.0, 95.0, 65.0, 72.0, 60.0};
            printWellnessReport(sampleHeights, sampleWeights);
        } else {
            double[] heights = new double[n];
            double[] weights = new double[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Person " + (i + 1) + " Height (m): ");
                heights[i] = Double.parseDouble(sc.nextLine().trim());
                System.out.print("Person " + (i + 1) + " Weight (kg): ");
                weights[i] = Double.parseDouble(sc.nextLine().trim());
            }
            printWellnessReport(heights, weights);
        }

        sc.close();
    }
}
