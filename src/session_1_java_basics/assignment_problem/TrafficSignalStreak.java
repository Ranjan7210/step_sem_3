package session_1_java_basics.assignment_problem;

import java.util.Scanner;

public class TrafficSignalStreak {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signals recorded");
            return;
        }

        char bestColor = signalLog.charAt(0);
        int maxStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char c = signalLog.charAt(i);
            if (c == currentColor) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    bestColor = currentColor;
                }
                currentColor = c;
                currentStreak = 1;
            }
        }

        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            bestColor = currentColor;
        }

        System.out.println("Longest Streak: '" + bestColor + "' repeated " + maxStreak + " times");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter signal log (or press enter for demo): ");
        String line = sc.nextLine().trim();

        if (line.isEmpty()) {
            findLongestStreak("RRGGGYRR");
            findLongestStreak("RRRRYYGG");
        } else {
            findLongestStreak(line);
        }

        sc.close();
    }
}
