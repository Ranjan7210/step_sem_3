package session_9.assignment_problem;

public class TicketPriceSlotFinder {

    static int findSlot(int[] prices, int newPrice) {
        int low = 0, high = prices.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (prices[mid] == newPrice) {
                return mid;
            } else if (prices[mid] < newPrice) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] prices1 = {100, 200, 300, 400, 500};
        System.out.println(findSlot(prices1, 350));

        int[] prices2 = {100, 200, 300, 400, 500};
        System.out.println(findSlot(prices2, 300));

        int[] prices3 = {100, 200, 400, 500};
        System.out.println(findSlot(prices3, 50));
    }
}
