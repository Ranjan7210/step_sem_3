package session_7_abstract_classes_and_interfaces.assignment_problem;

public abstract class ClassroomDevice {
    protected String assetTag;

    public ClassroomDevice() {
    }

    public ClassroomDevice(String assetTag) {
        this.assetTag = assetTag;
    }

    public abstract String operate();
}

interface Chargeable {
    String charge();
    String charge(int minutes);
}

class Tablet extends ClassroomDevice implements Chargeable {
    public Tablet(String assetTag) {
        super(assetTag);
    }

    @Override
    public String operate() {
        return "Tablet " + assetTag + " displaying lesson";
    }

    @Override
    public String charge() {
        return assetTag + " charging";
    }

    @Override
    public String charge(int minutes) {
        return assetTag + " charging for " + minutes + " minutes";
    }
}
