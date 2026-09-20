package session_5_access_modifiers_and_encapsulation.assignment_problem;

public class BookInventory {
    private int copiesTotal;
    private int copiesAvailable;

    public BookInventory(int copiesTotal) {
        if (copiesTotal <= 0) {
            this.copiesTotal = 0;
            this.copiesAvailable = 0;
        } else {
            this.copiesTotal = copiesTotal;
            this.copiesAvailable = copiesTotal;
        }
    }

    public void checkOut() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }

    public void checkIn() {
        if (copiesAvailable < copiesTotal) {
            copiesAvailable++;
        }
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public int getCopiesTotal() {
        return copiesTotal;
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 3: BookInventory Test ---");
        BookInventory b = new BookInventory(3);
        b.checkOut();
        b.checkOut();
        b.checkOut();
        b.checkOut(); // 4th attempt rejected
        System.out.println("After 4 checkOut calls: " + b.getCopiesAvailable());

        b.checkIn();
        b.checkIn();
        b.checkIn();
        b.checkIn(); // 4th attempt rejected
        System.out.println("After 4 checkIn calls: " + b.getCopiesAvailable());
    }
}
