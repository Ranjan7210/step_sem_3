package session_9.assignment_problem;

public class HotWeatherAlertWindows {

    static int countAlerts(int[] readings, int k, int threshold) {
        if (readings.length < k) {
            return 0;
        }
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += readings[i];
        }
        int alerts = (windowSum >= k * threshold) ? 1 : 0;
        for (int i = k; i < readings.length; i++) {
            windowSum += readings[i] - readings[i - k];
            if (windowSum >= k * threshold) {
                alerts++;
            }
        }
        return alerts;
    }

    public static void main(String[] args) {
        int[] readings1 = {30, 35, 40, 38, 25, 32, 36};
        System.out.println(countAlerts(readings1, 3, 35));

        int[] readings2 = {20, 22, 21, 23};
        System.out.println(countAlerts(readings2, 2, 30));
    }
}
