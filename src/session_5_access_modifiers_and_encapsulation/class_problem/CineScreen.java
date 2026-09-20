package session_5_access_modifiers_and_encapsulation.class_problem;

public class CineScreen {
    private int seatsTotal;
    private int seatsAvailable;

    public CineScreen(int seatsTotal) {
        if (seatsTotal <= 0) {
            System.out.println("Error: Construction rejected");
            this.seatsTotal = 0;
            this.seatsAvailable = 0;
        } else {
            this.seatsTotal = seatsTotal;
            this.seatsAvailable = seatsTotal;
        }
    }

    public void bookSeat() {
        if (seatsAvailable > 0) {
            seatsAvailable--;
        }
    }

    public void cancelBooking() {
        if (seatsAvailable < seatsTotal) {
            seatsAvailable++;
        }
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public int getSeatsTotal() {
        return seatsTotal;
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 3: CineScreen Test ---");

        System.out.print("new CineScreen(0): ");
        CineScreen cInvalid = new CineScreen(0);

        CineScreen c = new CineScreen(2);
        System.out.println("Initial seats available: " + c.getSeatsAvailable());

        c.bookSeat();
        c.bookSeat();
        c.bookSeat(); // 3rd booking rejected silently
        System.out.println("After 3 bookings: " + c.getSeatsAvailable());

        c.cancelBooking();
        c.cancelBooking();
        c.cancelBooking(); // 3rd cancellation rejected silently
        System.out.println("After 3 cancellations: " + c.getSeatsAvailable());
    }
}
