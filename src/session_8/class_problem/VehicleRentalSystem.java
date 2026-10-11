package session_8.class_problem;

abstract class Vehicle {
    protected String name;
    protected boolean available;

    public Vehicle(String name) {
        this.name = name;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract double calculateRentalCharge(int days);
}

class Sedan extends Vehicle {
    private static final double DAILY_RATE = 50.0;

    public Sedan(String name) {
        super(name);
    }

    @Override
    public double calculateRentalCharge(int days) {
        return DAILY_RATE * days;
    }
}

class SUV extends Vehicle {
    private static final double DAILY_RATE = 80.0;

    public SUV(String name) {
        super(name);
    }

    @Override
    public double calculateRentalCharge(int days) {
        return DAILY_RATE * days;
    }
}

class Truck extends Vehicle {
    private static final double DAILY_RATE = 100.0;

    public Truck(String name) {
        super(name);
    }

    @Override
    public double calculateRentalCharge(int days) {
        return DAILY_RATE * days;
    }
}

class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Rental {
    private Vehicle vehicle;
    private Customer customer;
    private int days;
    private double charge;

    public Rental(Vehicle vehicle, Customer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
        this.charge = vehicle.calculateRentalCharge(days);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getCharge() {
        return charge;
    }
}

public class VehicleRentalSystem {
    public static Rental rentVehicle(Customer customer, Vehicle vehicle, int days) {
        if (!vehicle.isAvailable()) {
            System.out.println(vehicle.getName() + " is currently unavailable.");
            return null;
        }
        vehicle.setAvailable(false);
        Rental rental = new Rental(vehicle, customer, days);
        System.out.println(vehicle.getName() + " rented successfully by " + customer.getName() + ". Rental charge: $" + (int) rental.getCharge() + ".");
        return rental;
    }

    public static void returnVehicle(Customer customer, Vehicle vehicle) {
        vehicle.setAvailable(true);
        System.out.println(vehicle.getName() + " returned by " + customer.getName() + ".");
    }

    public static void main(String[] args) {
        Customer c1 = new Customer("Customer 1");
        Customer c2 = new Customer("Customer 2");
        Customer c3 = new Customer("Customer 3");

        Vehicle sedanA = new Sedan("Sedan A");
        Vehicle suvB = new SUV("SUV B");

        rentVehicle(c1, sedanA, 3);
        rentVehicle(c2, sedanA, 2);
        returnVehicle(c1, sedanA);
        rentVehicle(c3, suvB, 5);
    }
}
