package session_8.class_problem;

enum LeaveStatus {
    PENDING("Pending"),
    APPROVED("Approved"),
    REJECTED("Rejected");

    private final String displayName;

    LeaveStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean canRequestLeave(int days);
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name) {
        super(name);
    }

    @Override
    public boolean canRequestLeave(int days) {
        return days <= 30;
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name) {
        super(name);
    }

    @Override
    public boolean canRequestLeave(int days) {
        return days <= 15;
    }
}

class Contractor extends Employee {
    public Contractor(String name) {
        super(name);
    }

    @Override
    public boolean canRequestLeave(int days) {
        return days <= 5;
    }
}

class LeaveRequest {
    private Employee employee;
    private String dates;
    private int days;
    private LeaveStatus status;

    public LeaveRequest(Employee employee, String dates, int days) {
        this.employee = employee;
        this.dates = dates;
        this.days = days;
        this.status = LeaveStatus.PENDING;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getDates() {
        return dates;
    }

    public LeaveStatus getStatus() {
        return status;
    }

    public boolean setStatus(LeaveStatus newStatus) {
        if ((this.status == LeaveStatus.APPROVED || this.status == LeaveStatus.REJECTED) && newStatus == LeaveStatus.PENDING) {
            System.out.println("Cannot change leave request status from " + this.status.getDisplayName() + " to " + newStatus.getDisplayName() + ".");
            return false;
        }
        this.status = newStatus;
        return true;
    }
}

class Manager {
    private String name;

    public Manager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void approve(LeaveRequest request) {
        if (request.setStatus(LeaveStatus.APPROVED)) {
            System.out.println(request.getEmployee().getName() + "'s leave request (" + request.getDates() + ") approved. Status: " + request.getStatus().getDisplayName() + ".");
        }
    }

    public void reject(LeaveRequest request) {
        if (request.setStatus(LeaveStatus.REJECTED)) {
            System.out.println(request.getEmployee().getName() + "'s leave request (" + request.getDates() + ") rejected. Status: " + request.getStatus().getDisplayName() + ".");
        }
    }
}

public class EmployeeLeaveRequestWorkflow {
    public static LeaveRequest submitLeaveRequest(Employee employee, String dates, int days) {
        LeaveRequest request = new LeaveRequest(employee, dates, days);
        System.out.println("Leave request submitted for " + employee.getName() + " (" + dates + "). Status: " + request.getStatus().getDisplayName() + ".");
        return request;
    }

    public static void main(String[] args) {
        Employee john = new FullTimeEmployee("John");
        Manager alice = new Manager("Alice");

        LeaveRequest req1 = submitLeaveRequest(john, "Jan 1-5", 5);
        alice.approve(req1);

        Employee jane = new PartTimeEmployee("Jane");
        Manager bob = new Manager("Bob");

        LeaveRequest req2 = submitLeaveRequest(jane, "Feb 10-11", 2);
        bob.reject(req2);

        req1.setStatus(LeaveStatus.PENDING);
    }
}
