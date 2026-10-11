package session_8.assignment_problem;

abstract class MembershipPlan {
    protected String name;
    protected int months;

    public MembershipPlan(String name, int months) {
        this.name = name;
        this.months = months;
    }

    public String getName() {
        return name;
    }

    public int getMonths() {
        return months;
    }

    public abstract double calculateFee();
}

class MonthlyPlan extends MembershipPlan {
    public MonthlyPlan() {
        super("Monthly", 1);
    }

    @Override
    public double calculateFee() {
        return 1000.00;
    }
}

class QuarterlyPlan extends MembershipPlan {
    public QuarterlyPlan() {
        super("Quarterly", 3);
    }

    @Override
    public double calculateFee() {
        return 3 * 1000.00 * 0.90;
    }
}

class AnnualPlan extends MembershipPlan {
    public AnnualPlan() {
        super("Annual", 12);
    }

    @Override
    public double calculateFee() {
        return 12 * 1000.00 * 0.75;
    }
}

enum MembershipStatus {
    ACTIVE("Active"),
    FROZEN("Frozen"),
    EXPIRED("Expired");

    private final String displayName;

    MembershipStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

class GymMember {
    private String name;

    public GymMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Membership {
    private GymMember member;
    private MembershipPlan plan;
    private MembershipStatus status;
    private double fee;

    public Membership(GymMember member, MembershipPlan plan) {
        this.member = member;
        this.plan = plan;
        this.status = MembershipStatus.ACTIVE;
        this.fee = plan.calculateFee();
        System.out.printf("%s membership created for %s. Fee: ₹%,.2f. Status: %s.\n",
                plan.getName(), member.getName(), fee, status.getDisplayName());
    }

    public GymMember getMember() {
        return member;
    }

    public MembershipPlan getPlan() {
        return plan;
    }

    public MembershipStatus getStatus() {
        return status;
    }

    public void checkIn() {
        if (status == MembershipStatus.ACTIVE) {
            System.out.println(member.getName() + " checked in successfully.");
        } else {
            System.out.println("Check-in denied: " + member.getName() + "'s membership is " + status.getDisplayName() + ".");
        }
    }

    public void freeze() {
        if (status == MembershipStatus.EXPIRED) {
            System.out.println("Cannot freeze an Expired membership.");
            return;
        }
        status = MembershipStatus.FROZEN;
        System.out.println(member.getName() + "'s membership frozen. Status: " + status.getDisplayName() + ".");
    }

    public void unfreeze() {
        if (status == MembershipStatus.EXPIRED) {
            System.out.println("Cannot unfreeze an Expired membership.");
            return;
        }
        status = MembershipStatus.ACTIVE;
        System.out.println(member.getName() + "'s membership unfrozen. Status: " + status.getDisplayName() + ".");
    }

    public void expire() {
        status = MembershipStatus.EXPIRED;
        System.out.println(member.getName() + "'s membership expired. Status: " + status.getDisplayName() + ".");
    }
}

public class FitZoneMembershipDesk {
    public static void main(String[] args) {
        GymMember asha = new GymMember("Asha");
        GymMember ravi = new GymMember("Ravi");

        Membership m1 = new Membership(asha, new QuarterlyPlan());
        Membership m2 = new Membership(ravi, new MonthlyPlan());

        m1.checkIn();
        m1.freeze();
        m1.checkIn();

        m2.expire();
        m2.freeze();
    }
}
