package session_9.assignment_problem;

import java.util.LinkedHashMap;
import java.util.Map;

public class MostPopularCanteenOrder {

    static String[] mostPopular(String[] orders) {
        LinkedHashMap<String, Integer> freq = new LinkedHashMap<String, Integer>();
        for (String order : orders) {
            if (freq.containsKey(order)) {
                freq.put(order, freq.get(order) + 1);
            } else {
                freq.put(order, 1);
            }
        }
        String topItem = null;
        int topCount = 0;
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > topCount) {
                topCount = entry.getValue();
                topItem = entry.getKey();
            }
        }
        return new String[]{topItem, String.valueOf(topCount)};
    }

    public static void main(String[] args) {
        String[] orders1 = {"Pasta", "Burger", "Pasta", "Pizza", "Burger", "Pasta"};
        String[] r1 = mostPopular(orders1);
        System.out.println("(" + r1[0] + ", " + r1[1] + ")");

        String[] orders2 = {"Tea", "Coffee", "Tea", "Coffee"};
        String[] r2 = mostPopular(orders2);
        System.out.println("(" + r2[0] + ", " + r2[1] + ")");
    }
}
