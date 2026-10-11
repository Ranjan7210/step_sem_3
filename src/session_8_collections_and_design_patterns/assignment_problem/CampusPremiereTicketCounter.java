package session_8.assignment_problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

abstract class Seat {
    protected String seatNumber;

    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public abstract double getPrice();
}

class RegularSeat extends Seat {
    public RegularSeat(String seatNumber) {
        super(seatNumber);
    }

    @Override
    public double getPrice() {
        return 150.00;
    }
}

class PremiumSeat extends Seat {
    public PremiumSeat(String seatNumber) {
        super(seatNumber);
    }

    @Override
    public double getPrice() {
        return 250.00;
    }
}

class ReclinerSeat extends Seat {
    public ReclinerSeat(String seatNumber) {
        super(seatNumber);
    }

    @Override
    public double getPrice() {
        return 400.00;
    }
}

class TicketCustomer {
    private String name;

    public TicketCustomer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Booking {
    private TicketCustomer customer;
    private Show show;
    private List<Seat> seats;
    private double total;

    public Booking(TicketCustomer customer, Show show, List<Seat> seats) {
        this.customer = customer;
        this.show = show;
        this.seats = seats;
        this.total = 0.0;
        for (Seat s : seats) {
            this.total += s.getPrice();
        }
    }

    public TicketCustomer getCustomer() {
        return customer;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public double getTotal() {
        return total;
    }

    public String getSeatNumbersString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seats.size(); i++) {
            sb.append(seats.get(i).getSeatNumber());
            if (i < seats.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}

class Show {
    private String name;
    private boolean started;
    private Set<String> bookedSeats;

    public Show(String name) {
        this.name = name;
        this.started = false;
        this.bookedSeats = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public Booking bookSeats(TicketCustomer customer, List<Seat> seats) {
        if (seats.size() > 6) {
            System.out.println("Maximum 6 seats per booking allowed.");
            return null;
        }

        for (Seat s : seats) {
            if (bookedSeats.contains(s.getSeatNumber())) {
                System.out.println("Seat " + s.getSeatNumber() + " is already booked for this show.");
                return null;
            }
        }

        for (Seat s : seats) {
            bookedSeats.add(s.getSeatNumber());
        }

        Booking booking = new Booking(customer, this, seats);
        System.out.printf("Booking confirmed for %s: %s. Total: ₹%.2f.\n",
                customer.getName(), booking.getSeatNumbersString(), booking.getTotal());
        return booking;
    }

    public void cancelBooking(Booking booking) {
        if (started) {
            System.out.println("Cannot cancel booking after show has started.");
            return;
        }

        for (Seat s : booking.getSeats()) {
            bookedSeats.remove(s.getSeatNumber());
        }

        System.out.println(booking.getCustomer().getName() + "'s booking cancelled. Seats " +
                booking.getSeatNumbersString() + " released.");
    }
}

public class CampusPremiereTicketCounter {
    public static void main(String[] args) {
        Show show7PM = new Show("7 PM");

        TicketCustomer asha = new TicketCustomer("Asha");
        TicketCustomer ravi = new TicketCustomer("Ravi");
        TicketCustomer neha = new TicketCustomer("Neha");

        List<Seat> ashaSeats = new ArrayList<>();
        ashaSeats.add(new RegularSeat("A1"));
        ashaSeats.add(new RegularSeat("A2"));
        ashaSeats.add(new PremiumSeat("F5"));

        Booking ashaBooking = show7PM.bookSeats(asha, ashaSeats);

        List<Seat> raviAttempt = new ArrayList<>();
        raviAttempt.add(new RegularSeat("A2"));
        show7PM.bookSeats(ravi, raviAttempt);

        List<Seat> raviSeats = new ArrayList<>();
        raviSeats.add(new ReclinerSeat("R1"));
        show7PM.bookSeats(ravi, raviSeats);

        if (ashaBooking != null) {
            show7PM.cancelBooking(ashaBooking);
        }

        List<Seat> nehaSeats = new ArrayList<>();
        nehaSeats.add(new RegularSeat("A2"));
        show7PM.bookSeats(neha, nehaSeats);
    }
}
