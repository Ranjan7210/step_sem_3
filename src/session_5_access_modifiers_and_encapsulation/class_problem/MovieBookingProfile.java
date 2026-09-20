package session_5_access_modifiers_and_encapsulation.class_problem;

public class MovieBookingProfile {
    private String name;
    private boolean confirmed;
    private String otp;

    public MovieBookingProfile() {
        this.name = null;
        this.confirmed = false;
        this.otp = null;
    }

    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 4: MovieBookingProfile Test ---");

        MovieBookingProfile profile1 = new MovieBookingProfile("Rahul Dev");
        System.out.println("profile1.getName(): " + profile1.getName());

        profile1.setConfirmed(true);
        System.out.println("profile1.isConfirmed(): " + profile1.isConfirmed());

        profile1.setOtp("4471");
        System.out.println("OTP successfully set via write-only setOtp(\"4471\") method.");
    }
}
