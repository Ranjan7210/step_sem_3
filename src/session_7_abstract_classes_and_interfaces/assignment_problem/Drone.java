package session_7_abstract_classes_and_interfaces.assignment_problem;

public abstract class Drone {
    protected String id;

    public Drone() {
    }

    public Drone(String id) {
        this.id = id;
    }

    public abstract String fly();

    public static String getLocationIfTrackable(Object o) {
        if (o instanceof Trackable) {
            return ((Trackable) o).getLocation();
        }
        return "Tracking not available";
    }
}

interface Trackable {
    String getLocation();

    static String getLocationIfTrackable(Object o) {
        return Drone.getLocationIfTrackable(o);
    }
}

class DeliveryDrone extends Drone implements Trackable {
    public DeliveryDrone(String id) {
        super(id);
    }

    @Override
    public String fly() {
        return id + " flying delivery route";
    }

    @Override
    public String getLocation() {
        return id + " at Sector 4";
    }
}

class ScoutDrone extends Drone {
    public ScoutDrone(String id) {
        super(id);
    }

    @Override
    public String fly() {
        return id + " scouting airspace";
    }
}

class GroundRobot implements Trackable {
    private String id;

    public GroundRobot(String id) {
        this.id = id;
    }

    @Override
    public String getLocation() {
        return id + " at Sector 4";
    }
}
