package session_8.assignment_problem;

abstract class WashType {
    protected String name;
    protected int durationMinutes;
    protected double charge;

    public WashType(String name, int durationMinutes, double charge) {
        this.name = name;
        this.durationMinutes = durationMinutes;
        this.charge = charge;
    }

    public String getName() {
        return name;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public double getCharge() {
        return charge;
    }
}

class QuickWash extends WashType {
    public QuickWash() {
        super("Quick", 30, 20.00);
    }
}

class NormalWash extends WashType {
    public NormalWash() {
        super("Normal", 45, 30.00);
    }
}

class HeavyWash extends WashType {
    public HeavyWash() {
        super("Heavy", 60, 45.00);
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class WashingMachine {
    private String id;
    private boolean busy;
    private WashCycle currentCycle;

    public WashingMachine(String id) {
        this.id = id;
        this.busy = false;
    }

    public String getId() {
        return id;
    }

    public boolean isBusy() {
        return busy;
    }

    public WashCycle startWash(Student student, WashType washType) {
        if (busy) {
            System.out.println("Machine " + id + " is currently busy.");
            return null;
        }
        busy = true;
        currentCycle = new WashCycle(student, this, washType);
        System.out.printf("%s wash started on %s for %s (%d min). Charge: ₹%.2f.\n",
                washType.getName(), id, student.getName(), washType.getDurationMinutes(), washType.getCharge());
        return currentCycle;
    }

    public void completeCycle() {
        if (busy) {
            busy = false;
            currentCycle = null;
            System.out.println(id + " cycle completed. " + id + " is now free.");
        }
    }
}

class WashCycle {
    private Student student;
    private WashingMachine machine;
    private WashType washType;

    public WashCycle(Student student, WashingMachine machine, WashType washType) {
        this.student = student;
        this.machine = machine;
        this.washType = washType;
    }

    public Student getStudent() {
        return student;
    }

    public WashingMachine getMachine() {
        return machine;
    }

    public WashType getWashType() {
        return washType;
    }
}

public class HostelLaundryQueue {
    public static void main(String[] args) {
        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        m1.startWash(asha, new QuickWash());
        m1.startWash(ravi, new HeavyWash());
        m2.startWash(ravi, new HeavyWash());
        m1.completeCycle();
        m1.startWash(neha, new NormalWash());
    }
}
