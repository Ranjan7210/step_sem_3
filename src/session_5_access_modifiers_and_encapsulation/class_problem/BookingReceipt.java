package session_5_access_modifiers_and_encapsulation.class_problem;

import java.util.Arrays;

public class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = seatNumbers != null ? seatNumbers.clone() : new String[0];
    }

    public String getBookingId() {
        return bookingId;
    }

    public String[] getSeatNumbers() {
        return seatNumbers != null ? seatNumbers.clone() : new String[0];
    }

    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        if (seatNumbers == null || index < 0 || index >= seatNumbers.length) {
            return this;
        }
        String[] updated = seatNumbers.clone();
        updated[index] = newSeat;
        return new BookingReceipt(this.bookingId, updated);
    }

    public static String processNightlySettlement(BookingReceipt[] receipts) {
        int nullSkipped = 0;
        int groupCount = 0;
        int individualCount = 0;

        if (receipts != null) {
            for (BookingReceipt receipt : receipts) {
                if (receipt == null) {
                    nullSkipped++;
                } else if (receipt instanceof GroupBookingReceipt) {
                    groupCount++;
                } else {
                    individualCount++;
                }
            }
        }

        int processed = groupCount + individualCount;
        return processed + " processed | " + nullSkipped + " null skipped | " + groupCount + " group | " + individualCount + " individual";
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 5: BookingReceipt Test ---");

        BookingReceipt b = new BookingReceipt("CH-1001", new String[]{"A1", "A2"});
        String[] seats = b.getSeatNumbers();
        seats[0] = "X";
        System.out.println("Defensive copy check (b.getSeatNumbers()[0]): " + b.getSeatNumbers()[0]);

        BookingReceipt updated = b.withUpdatedSeat(1, "A3");
        System.out.println("Original b.getSeatNumbers(): " + Arrays.toString(b.getSeatNumbers()));
        System.out.println("Updated getSeatNumbers(): " + Arrays.toString(updated.getSeatNumbers()));

        BookingReceipt[] batch = new BookingReceipt[]{
            new GroupBookingReceipt("CH-2002", new String[]{"B1", "B2"}, 2),
            null,
            new BookingReceipt("CH-3003", new String[]{"C1"})
        };
        System.out.println("processNightlySettlement: " + processNightlySettlement(batch));
    }
}
