package session_6_inheritance_and_polymorphism.assignment_problem;

import java.util.Arrays;

public class GymReport {

    public static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        }
        if (member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        }
        if (member instanceof PremiumMember) {
            return "Direct descendant (2 generations deep)";
        }
        return "Base generation";
    }

    public static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;
        if (members != null) {
            for (GymMember m : members) {
                if (m != null) {
                    total += m.getSessionsAttended();
                }
            }
        }
        return total;
    }

    public static String batchPrint(GymMember[] members) {
        StringBuilder sb = new StringBuilder();
        if (members != null) {
            for (GymMember m : members) {
                if (m != null) {
                    sb.append(m.displayInfo());
                    if (m instanceof PremiumMember) {
                        PremiumMember pm = (PremiumMember) m;
                        sb.append(" [Trainer via downcast: ").append(pm.getTrainerName()).append("]");
                    }
                    sb.append(" | ");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 1: GymMember & PremiumMember Test ---");
        try {
            new GymMember("GM1", 1000);
        } catch (IllegalArgumentException e) {
            System.out.println("new GymMember(\"GM1\", 1000): " + e.getMessage());
        }

        PremiumMember p = new PremiumMember("MEM01", 2000, "Coach Riya");
        p.attendSession();
        p.attendSession();
        System.out.println("p.getSessionsAttended(): " + p.getSessionsAttended());
        System.out.println("signUpBatch: " + GymMember.signUpBatch(new String[]{"MEM1", "GM1", "MEM2", "  ", "MEM3"}, 1000));

        System.out.println("\n--- Problem 2: Three Tiers Test ---");
        EliteMember em = new EliteMember("MEM3", 3000, "Coach Arjun", "L12");
        GroupClassMember gc = new GroupClassMember("MEM4", 1500, "Zumba");
        System.out.println(new GymMember("MEM1", 1000).displayInfo());
        System.out.println(p.displayInfo());
        System.out.println(em.displayInfo());
        System.out.println(gc.displayInfo());
        System.out.println("classifyGeneration(elite): " + classifyGeneration(em));
        System.out.println("classifyGeneration(group): " + classifyGeneration(gc));

        PremiumMember pm2 = new PremiumMember("MEM5", 2000, "Coach Riya");
        pm2.attendSession(); pm2.attendSession(); pm2.attendSession();
        em.attendSession(); em.attendSession();
        gc.attendSession(); gc.attendSession(); gc.attendSession(); gc.attendSession();
        System.out.println("getTotalSessionsAttended: " + getTotalSessionsAttended(new GymMember[]{pm2, em, gc}));

        System.out.println("\n--- Problem 3: Late Fee Ledger Test ---");
        PremiumMember p3 = new PremiumMember("MEM55", 2000, "Coach Riya");
        p3.chargeLateFee(200);
        System.out.println("p3.getTotalLateFees(): " + p3.getTotalLateFees());
        int[] hist = p3.getLateFeeHistory();
        hist[0] = 999;
        System.out.println("p3.getLateFeeHistory() after tamper: " + Arrays.toString(p3.getLateFeeHistory()));

        System.out.println("\n--- Problem 4: batchPrint Test ---");
        System.out.println("batchPrint: " + batchPrint(new GymMember[]{new GymMember("MEM6", 1000), new PremiumMember("MEM7", 2000, "Coach Riya")}));

        System.out.println("\n--- Problem 5: membershipNumber, referralCode, payFee, processWeeklyCheckIn Test ---");
        GymMember m1 = new GymMember(1000);
        System.out.println("m1.membershipNumber: " + m1.membershipNumber);
        System.out.println("isValidReferralCode(\"G45B\"): " + GymMember.isValidReferralCode("G45B"));
        System.out.println("isValidReferralCode(\"G4B\"): " + GymMember.isValidReferralCode("G4B"));
        System.out.println("isValidReferralCode(\"X45B\"): " + GymMember.isValidReferralCode("X45B"));
        m1.payFee(500);
        m1.payFee(500, "UPI");
        System.out.println("m1.getFeesPaid(): " + m1.getFeesPaid());
        System.out.println("processWeeklyCheckIn: " + GymMember.processWeeklyCheckIn(new GymMember[]{new GroupClassMember(1000, "Zumba"), null, new GymMember(1000)}));
    }
}
