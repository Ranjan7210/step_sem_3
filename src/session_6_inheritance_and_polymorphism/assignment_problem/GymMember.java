package session_6_inheritance_and_polymorphism.assignment_problem;

public class GymMember {
    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;

    private int[] lateFeeHistory = new int[10];
    private int lateFeeCount = 0;
    private int feesPaid = 0;

    private static int membersEnrolled = 0;
    private static int memberCounter = 2001;
    public final String membershipNumber;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
        this.membershipNumber = "GYM-" + memberCounter;
        membersEnrolled++;
        memberCounter++;
    }

    public GymMember(int monthlyFee) {
        this.memberId = "GYM-" + memberCounter;
        this.membershipNumber = "GYM-" + memberCounter;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
        membersEnrolled++;
        memberCounter++;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public String getMemberId() {
        return memberId;
    }

    protected void chargeLateFee(int amount) {
        if (lateFeeCount < lateFeeHistory.length) {
            lateFeeHistory[lateFeeCount++] = amount;
        }
    }

    public int[] getLateFeeHistory() {
        int[] copy = new int[lateFeeCount];
        System.arraycopy(lateFeeHistory, 0, copy, 0, lateFeeCount);
        return copy;
    }

    public int getTotalLateFees() {
        int total = 0;
        for (int i = 0; i < lateFeeCount; i++) {
            total += lateFeeHistory[i];
        }
        return total;
    }

    public void payFee(int amount) {
        feesPaid += amount;
    }

    public void payFee(int amount, String mode) {
        payFee(amount);
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public String displayInfo() {
        return "Standard Member | Sessions: " + sessionsAttended;
    }

    public static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0;
        int rejected = 0;
        if (memberIds != null) {
            for (String id : memberIds) {
                try {
                    new GymMember(id, monthlyFee);
                    signedUp++;
                } catch (IllegalArgumentException e) {
                    rejected++;
                }
            }
        }
        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }

    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }
        if (code.charAt(0) != 'G') {
            return false;
        }
        if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2))) {
            return false;
        }
        if (!Character.isUpperCase(code.charAt(3))) {
            return false;
        }
        return true;
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }

    public static String processWeeklyCheckIn(GymMember[] members) {
        int nullSkipped = 0;
        int groupCount = 0;
        int regularCount = 0;

        if (members != null) {
            for (GymMember m : members) {
                if (m == null) {
                    nullSkipped++;
                } else if (m instanceof GroupClassMember) {
                    groupCount++;
                } else {
                    regularCount++;
                }
            }
        }

        int processed = groupCount + regularCount;
        return processed + " processed | " + nullSkipped + " null skipped | " + groupCount + " group | " + regularCount + " regular";
    }
}
