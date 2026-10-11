package session_8.class_problem;

import java.util.ArrayList;
import java.util.List;

abstract class Room {
    protected int roomNumber;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public abstract String getCategoryName();

    public abstract double calculatePrice(int nights);

    public String getFullName() {
        return getCategoryName() + " " + roomNumber;
    }
}

class StandardRoom extends Room {
    private static final double RATE_PER_NIGHT = 100.0;

    public StandardRoom(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public String getCategoryName() {
        return "Standard Room";
    }

    @Override
    public double calculatePrice(int nights) {
        return RATE_PER_NIGHT * nights;
    }
}

class DeluxeRoom extends Room {
    private static final double RATE_PER_NIGHT = 180.0;

    public DeluxeRoom(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public String getCategoryName() {
        return "Deluxe Room";
    }

    @Override
    public double calculatePrice(int nights) {
        return RATE_PER_NIGHT * nights;
    }
}

class Suite extends Room {
    private static final double RATE_PER_NIGHT = 300.0;

    public Suite(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public String getCategoryName() {
        return "Suite";
    }

    @Override
    public double calculatePrice(int nights) {
        return RATE_PER_NIGHT * nights;
    }
}

class HotelCustomer {
    private String name;

    public HotelCustomer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Reservation {
    private HotelCustomer customer;
    private Room room;
    private String periodText;
    private int startDay;
    private int endDay;
    private int nights;
    private double price;
    private boolean active;

    public Reservation(HotelCustomer customer, Room room, String periodText, int startDay, int endDay, int nights) {
        this.customer = customer;
        this.room = room;
        this.periodText = periodText;
        this.startDay = startDay;
        this.endDay = endDay;
        this.nights = nights;
        this.price = room.calculatePrice(nights);
        this.active = true;
    }

    public HotelCustomer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public String getPeriodText() {
        return periodText;
    }

    public int getStartDay() {
        return startDay;
    }

    public int getEndDay() {
        return endDay;
    }

    public double getPrice() {
        return price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean overlaps(int sDay, int eDay) {
        return active && !(eDay <= startDay || sDay >= endDay);
    }
}

public class HotelBookingSystem {
    private static List<Reservation> reservations = new ArrayList<>();

    public static boolean checkAvailability(Room room, String fromText, int sDay, int eDay) {
        for (Reservation r : reservations) {
            if (r.getRoom().getRoomNumber() == room.getRoomNumber() && r.overlaps(sDay, eDay)) {
                System.out.println(room.getFullName() + " is not available " + fromText + ".");
                return false;
            }
        }
        System.out.println(room.getFullName() + " is available " + fromText + ".");
        return true;
    }

    public static Reservation reserveRoom(HotelCustomer customer, Room room, String fromText, String shortPeriod, int sDay, int eDay, int nights) {
        for (Reservation r : reservations) {
            if (r.getRoom().getRoomNumber() == room.getRoomNumber() && r.overlaps(sDay, eDay)) {
                System.out.println(room.getFullName() + " is not available " + fromText + ".");
                return null;
            }
        }
        Reservation res = new Reservation(customer, room, shortPeriod, sDay, eDay, nights);
        reservations.add(res);
        System.out.println("Reservation confirmed for " + customer.getName() + ", " + room.getFullName() + " (" + shortPeriod + "). Price: $" + (int) res.getPrice() + ".");
        return res;
    }

    public static void cancelReservation(Reservation reservation, boolean beforeDeadline) {
        if (reservation != null && reservation.isActive()) {
            if (beforeDeadline) {
                reservation.setActive(false);
                System.out.println("Reservation for " + reservation.getCustomer().getName() + ", " + reservation.getRoom().getFullName() + " (" + reservation.getPeriodText() + ") cancelled successfully.");
            } else {
                System.out.println("Cancellation deadline has passed.");
            }
        }
    }

    public static void main(String[] args) {
        Room r101 = new StandardRoom(101);
        Room r201 = new DeluxeRoom(201);

        HotelCustomer custA = new HotelCustomer("Customer A");
        HotelCustomer custB = new HotelCustomer("Customer B");
        HotelCustomer custC = new HotelCustomer("Customer C");

        checkAvailability(r101, "from Jan 1 to Jan 5", 1, 5);
        Reservation resA = reserveRoom(custA, r101, "from Jan 1 to Jan 5", "Jan 1-5", 1, 5, 4);
        reserveRoom(custB, r101, "from Jan 3 to Jan 7", "Jan 3-7", 3, 7, 4);
        cancelReservation(resA, true);
        reserveRoom(custC, r201, "from Feb 10 to Feb 12", "Feb 10-12", 41, 43, 2);
    }
}
