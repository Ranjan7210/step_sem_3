package session_5_access_modifiers_and_encapsulation.class_problem;

public class MovieTicket {
    private String seatNumber;
    String screenId; // default (package-private)
    protected double ticketPrice;
    public String movieTitle;

    public MovieTicket(String seatNumber, String screenId, double ticketPrice, String movieTitle) {
        this.seatNumber = seatNumber;
        this.screenId = screenId;
        this.ticketPrice = ticketPrice;
        this.movieTitle = movieTitle;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getScreenId() {
        return screenId;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public String getMovieTitle() {
        return movieTitle;
    }
}
